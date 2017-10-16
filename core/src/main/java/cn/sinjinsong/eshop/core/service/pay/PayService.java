package cn.sinjinsong.eshop.core.service.pay;

import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;

/**
 * Created by SinjinSong on 2017/10/7.
 */
public interface PayService {
    void deposit(Long userId, Integer amount);
    void pay(OrderDO order,String paymentPassword);
    void setPaymentPassword(Long userId,String oldPaymentPassword,String newPaymentPassword);
}
