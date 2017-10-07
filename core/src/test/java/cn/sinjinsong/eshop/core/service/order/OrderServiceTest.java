package cn.sinjinsong.eshop.core.service.order;

import cn.sinjinsong.eshop.core.BaseSpringTest;
import cn.sinjinsong.eshop.core.domain.entity.order.OrderDO;
import cn.sinjinsong.eshop.core.enumeration.order.OrderStatus;
import cn.sinjinsong.eshop.core.service.product.ProductService;
import cn.sinjinsong.eshop.core.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Slf4j
public class OrderServiceTest extends BaseSpringTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void placeOrder() throws Exception {
        OrderDO order = new OrderDO();
        order.setUser(userService.findById(14L));
        order.setOrderStatus(OrderStatus.UNPAID);
        order.setPlaceTime(LocalDateTime.now());
        order.setProduct(productService.findProductById(1L));
        order.setQuantity(1);
        order.setTotalPrice(300d);
        orderService.placeOrder(order);
        log.info("{}", orderService.findById(order.getId()));
    }

    @Test
    public void findAll() throws Exception {
        orderService.findAll(1, 5).getList().forEach(System.out::println);
    }

    @Test
    public void findAllByCondition() throws Exception {
//        orderService.findAllByCondition(OrderQueryConditionDTO.builder().status(OrderStatus.PAID).build(),0,0).getList().forEach(System.out::println);
//        LocalDateTime begin = LocalDateTime.of(2017,10,6,0,0);
//        LocalDateTime end = LocalDateTime.of(2017,10,7,0,0);
                
//        orderService.findAllByCondition(OrderQueryConditionDTO.builder().begin(begin).end(end).build(),0,0).getList().forEach(System.out::println);
//        orderService.findAllByCondition(OrderQueryConditionDTO.builder().userId(1L).categoryId(1L).build(),0,0).getList().forEach(System.out::println);
    }
    
    @Test
    public void findById() throws Exception {
        log.info("{}", orderService.findById(1L));
    }
    
    @Test
    public void updateOrder() throws Exception {
        OrderDO order = orderService.findById(4L);
        order.setOrderStatus(OrderStatus.TIME_OUT);
        orderService.updateOrder(order);
        log.info("{}",orderService.findById(4L));
    }
}