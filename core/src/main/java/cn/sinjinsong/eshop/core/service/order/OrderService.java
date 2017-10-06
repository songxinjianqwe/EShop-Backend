package cn.sinjinsong.eshop.core.service.order;

import cn.sinjinsong.eshop.core.domain.dto.order.OrderQueryConditionDTO;
import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;
import com.github.pagehelper.PageInfo;

/**
 * Created by SinjinSong on 2017/10/6.
 */
public interface OrderService {
    void placeOrder(OrderDO order);

    PageInfo<OrderDO> findAll(Integer pageNum, Integer pageSize);

    PageInfo<OrderDO> findAllByCondition(OrderQueryConditionDTO queryDTO, Integer pageNum, Integer pageSize);
    OrderDO findById(Long orderId);
    void updateOrder(OrderDO order);
    void updateTimeOutOrders();
}
