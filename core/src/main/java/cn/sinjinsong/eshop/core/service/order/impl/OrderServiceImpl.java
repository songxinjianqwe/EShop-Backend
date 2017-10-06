package cn.sinjinsong.eshop.core.service.order.impl;

import cn.sinjinsong.eshop.core.dao.order.OrderDOMapper;
import cn.sinjinsong.eshop.core.domain.dto.order.OrderQueryConditionDTO;
import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;
import cn.sinjinsong.eshop.core.enumeration.order.OrderStatus;
import cn.sinjinsong.eshop.core.properties.OrderProperties;
import cn.sinjinsong.eshop.core.service.order.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDOMapper mapper;

    @Transactional
    @Override
    public void placeOrder(OrderDO order) {
        mapper.insert(order);
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<OrderDO> findAll(Integer pageNum, Integer pageSize) {
        return mapper.findAll(pageNum, pageSize).toPageInfo();
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<OrderDO> findAllByCondition(OrderQueryConditionDTO queryDTO, Integer pageNum, Integer pageSize) {
        return mapper.findByCondition(queryDTO, pageNum, pageSize).toPageInfo();
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDO findById(Long orderId) {
        return mapper.selectByPrimaryKey(orderId);
    }

    @Transactional
    @Override
    public void updateOrder(OrderDO order) {
        mapper.updateByPrimaryKeySelective(order);
    }

    @Transactional
    @Override
    public void updateTimeOutOrders() {
        findAllByCondition(OrderQueryConditionDTO.builder().status(OrderStatus.UNPAID).build(), 0, 0).getList().forEach(
                (OrderDO order) -> {
                    if (Duration.between(LocalDateTime.now(), order.getPlaceTime()).toMinutes() >= OrderProperties.TIME_OUT_SPAN) {
                        order.setOrderStatus(OrderStatus.TIME_OUT);
                        mapper.updateByPrimaryKeySelective(order);
                    }
                }
        );
    }
}
