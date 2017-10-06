package cn.sinjinsong.eshop.core.service.news;

import cn.sinjinsong.eshop.core.BaseSpringTest;
import cn.sinjinsong.eshop.core.domain.entity.news.NewsDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Slf4j
public class NewsServiceTest extends BaseSpringTest{
    @Autowired
    private NewsService service;
    
    @Test
    public void findAllNews() throws Exception {
        service.findAllNews().forEach(System.out::println);
    }

    @Test
    public void findLatestNews() throws Exception {
        service.findLatestNews(5).forEach(System.out::println);
    }

    @Test
    public void save() throws Exception {
        NewsDO news = new NewsDO();
        news.setTitle("新增课程:Laravel");
        news.setBody("Laravel");
        news.setTime(LocalDateTime.now());
        service.save(news);
        log.info("{}",service.findById(news.getId()));
    }

    @Test
    public void update() throws Exception {
    }

}