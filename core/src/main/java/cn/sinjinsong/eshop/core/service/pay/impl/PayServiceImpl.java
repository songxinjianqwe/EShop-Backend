package cn.sinjinsong.eshop.core.service.pay.impl;

import cn.sinjinsong.eshop.core.dao.pay.BalanceDOMapper;
import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;
import cn.sinjinsong.eshop.core.domain.entity.pay.BalanceDO;
import cn.sinjinsong.eshop.core.domain.entity.user.UserDO;
import cn.sinjinsong.eshop.core.enumeration.order.OrderStatus;
import cn.sinjinsong.eshop.core.exception.order.OrderStateIllegalException;
import cn.sinjinsong.eshop.core.exception.pay.BalanceNotEnoughException;
import cn.sinjinsong.eshop.core.exception.pay.PaymentPasswordInCorrectException;
import cn.sinjinsong.eshop.core.service.order.OrderService;
import cn.sinjinsong.eshop.core.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SinjinSong on 2017/10/7.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private BalanceDOMapper balanceDOMapper;
    @Autowired
    private OrderService orderService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Transactional
    @Override
    public void deposit(Long userId, Double amount) {
        BalanceDO balanceDO = balanceDOMapper.selectByPrimaryKey(userId);
        balanceDO.setBalance(balanceDO.getBalance() + amount);
        balanceDOMapper.updateByPrimaryKeySelective(balanceDO);
    }

    @Transactional
    @Override
    public void pay(OrderDO order,String paymentPassword) {
        if (order.getOrderStatus() != OrderStatus.UNPAID) {
            throw new OrderStateIllegalException(order.getOrderStatus().toString());
        }
        BalanceDO balanceDO = balanceDOMapper.selectByPrimaryKey(order.getUser().getId());
        if (balanceDO == null) {
            throw new BalanceNotEnoughException("0");
        }
        if (order.getTotalPrice().compareTo(balanceDO.getBalance()) > 0) {
            throw new BalanceNotEnoughException(String.valueOf(balanceDO.getBalance()));
        }
        if(!passwordEncoder.matches(paymentPassword,balanceDO.getPaymentPassword())){
            throw new PaymentPasswordInCorrectException(order.getUser().getUsername());
        }
        balanceDO.setBalance(balanceDO.getBalance() - order.getTotalPrice());
        balanceDOMapper.updateByPrimaryKeySelective(balanceDO);

        order.setOrderStatus(OrderStatus.PAID);
        orderService.updateOrder(order);
    }

    @Override
    public void setPaymentPassword(Long userId, String paymentPassword) {
        
        balanceDOMapper.updateByPrimaryKeySelective(new BalanceDO(new UserDO(userId),null,passwordEncoder.encode(paymentPassword)));
    }
}
