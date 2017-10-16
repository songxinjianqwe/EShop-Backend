package cn.sinjinsong.eshop.core.service.news;

import cn.sinjinsong.eshop.core.domain.entity.news.NewsDO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/6.
 */
public interface NewsService {
    PageInfo<NewsDO> findAllNews(Integer pageNum, Integer pageSize);
    List<NewsDO> findLatestNews(Integer count);
    void save(NewsDO news);
    void update(NewsDO news);
    NewsDO findById(Long id);
}
