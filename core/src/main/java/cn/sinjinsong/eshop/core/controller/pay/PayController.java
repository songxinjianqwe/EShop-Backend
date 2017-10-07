package cn.sinjinsong.eshop.core.controller.pay;

import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;
import cn.sinjinsong.eshop.core.exception.order.OrderNotFoundException;
import cn.sinjinsong.eshop.core.exception.pay.DepositException;
import cn.sinjinsong.eshop.core.exception.user.AccessDeniedException;
import cn.sinjinsong.eshop.core.security.domain.JWTUser;
import cn.sinjinsong.eshop.core.service.order.OrderService;
import cn.sinjinsong.eshop.core.service.pay.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SinjinSong on 2017/10/7.
 */
@RestController
@Api(value = "pay", description = "支付相关")
@Slf4j
public class PayController {
    @Autowired
    private PayService payService;
    @Autowired
    private OrderService orderService;
    
    @RequestMapping(value = "/deposit/{userId}", method = RequestMethod.POST)
    @ApiOperation(value="充值",authorizations = {@Authorization("登录")})
    public void deposit(@PathVariable("userId") @ApiParam(value="用户id",required = true) Long userId, @RequestParam("amount") @ApiParam(value="充值金额",required = true) Double amount) {
        if(amount <= 0){
            throw new DepositException(String.valueOf(amount));
        }
        payService.deposit(userId, amount);
    }
    
    @RequestMapping(value= "/pay/{orderId}",method = RequestMethod.POST)
    @ApiOperation(value="订单付款",authorizations = {@Authorization("登录")})
    public void pay(@PathVariable("orderId") @ApiParam(value="订单id",required = true) Long orderId, @AuthenticationPrincipal JWTUser user) {
        OrderDO order = orderService.findById(orderId);
        if(order == null){
            throw new OrderNotFoundException(String.valueOf(orderId));
        }
        if(!user.getUsername().equals(order.getUser().getUsername())){
            throw new AccessDeniedException(user.getUsername());
        }
        payService.pay(order);
    }
}
