package cn.sinjinsong.eshop.core.service.pay;

import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;

/**
 * Created by SinjinSong on 2017/10/7.
 */
public interface PayService {
    void deposit(Long userId, Double amount);
    void pay(OrderDO order);
}
