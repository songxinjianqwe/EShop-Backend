package cn.sinjinsong.eshop.core.domain.entity.order;

import cn.sinjinsong.eshop.core.domain.entity.product.ProductDO;
import cn.sinjinsong.eshop.core.domain.entity.user.UserDO;
import cn.sinjinsong.eshop.core.enumeration.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.product
     *
     * @mbggenerated
     */
    private ProductDO product;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.quantity
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user
     *
     * @mbggenerated
     */
    private UserDO user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.place_time
     *
     * @mbggenerated
     */
    private LocalDateTime placeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.total_price
     *
     * @mbggenerated
     */
    private Double totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_status
     *
     * @mbggenerated
     */
    private OrderStatus orderStatus;
}