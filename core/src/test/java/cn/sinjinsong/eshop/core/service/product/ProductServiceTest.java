package cn.sinjinsong.eshop.core.service.product;

import cn.sinjinsong.eshop.core.BaseSpringTest;
import cn.sinjinsong.eshop.core.domain.entity.product.ProductDO;
import cn.sinjinsong.eshop.core.enumeration.product.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Slf4j
public class ProductServiceTest extends BaseSpringTest {
    @Autowired
    private ProductService service;
    
    @Test
    public void findAllCategories() throws Exception {
        service.findAllCategories().forEach(System.out::println);
    }

    @Test
    public void findProductByCategory() throws Exception {
        service.findProductByCategory(1L,1,5).getList().forEach(System.out::println);
    }

    @Test
    public void findProductById() throws Exception {
        log.info("{}",service.findProductById(1L));
    }

    @Test
    public void saveProduct() throws Exception {
        ProductDO productDO = new ProductDO();
        productDO.setCategory(service.findCategoryById(6L));
        productDO.setName("Laravel");
        productDO.setType(ProductType.HIGH);
        productDO.setDescription("PHP框架");
        service.saveProduct(productDO);
        log.info("{}",service.findProductById(productDO.getId()));
    }

    @Test
    public void updateProduct() throws Exception {
        ProductDO product = service.findProductById(1L);
        product.setDescription("JavaSE语法学习");
        service.updateProduct(product);
        log.info("{}",service.findProductById(product.getId()));
    }

    @Test
    public void saveCategory() throws Exception {
        service.saveCategory(".Net");
        service.findAllCategories().forEach(System.out::println);
    }

    @Test
    public void updateCategory() throws Exception {
    }

}