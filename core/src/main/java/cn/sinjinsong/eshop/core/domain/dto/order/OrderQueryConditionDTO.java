package cn.sinjinsong.eshop.core.domain.dto.order;

import cn.sinjinsong.eshop.core.enumeration.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderQueryConditionDTO {
    private Long userId;
    private Long categoryId;
    private LocalDateTime begin;
    private LocalDateTime end;
    private OrderStatus status;
}
