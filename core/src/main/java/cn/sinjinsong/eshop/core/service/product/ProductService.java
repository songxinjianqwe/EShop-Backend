package cn.sinjinsong.eshop.core.service.product;

import cn.sinjinsong.eshop.core.domain.entity.product.ProductCategoryDO;
import cn.sinjinsong.eshop.core.domain.entity.product.ProductDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/6.
 */
public interface ProductService {
    ProductCategoryDO findCategoryById(Long categoryId);
    List<ProductCategoryDO> findAllCategories();
    List<ProductCategoryDO> findCategoriesOnBoard();
    PageInfo<ProductDO> findProductByCategory(Long categoryId,Integer pageNum, Integer pageSize);
    ProductDO findProductById(Long productId);
    void saveProduct(ProductDO product);
    void updateProduct(ProductDO product);
    void saveCategory(String categoryName);
    void updateCategory(ProductCategoryDO category);
}
