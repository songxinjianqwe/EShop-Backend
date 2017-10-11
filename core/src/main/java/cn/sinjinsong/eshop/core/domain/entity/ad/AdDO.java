package cn.sinjinsong.eshop.core.domain.entity.ad;

import cn.sinjinsong.eshop.core.domain.entity.product.ProductDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad.product
     *
     * @mbggenerated
     */
    private ProductDO product;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad.image_src
     *
     * @mbggenerated
     */
    private String imageSrc;
}