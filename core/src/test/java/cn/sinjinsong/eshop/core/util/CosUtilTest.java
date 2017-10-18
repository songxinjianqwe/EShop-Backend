package cn.sinjinsong.eshop.core.util;

import cn.sinjinsong.eshop.core.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SinjinSong on 2017/10/18.
 */
@Slf4j
public class CosUtilTest extends BaseSpringTest{
    @Autowired
    private CosUtil util;
    @Test
    public void getSignOnce() throws Exception {
        String sign = util.getSign("eshop", "user/avatar/1.jpg");
        log.info(sign);  
    }

}