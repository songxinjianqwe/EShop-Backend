package cn.sinjinsong.eshop.core.service.news.impl;

import cn.sinjinsong.eshop.core.dao.news.NewsDOMapper;
import cn.sinjinsong.eshop.core.domain.entity.news.NewsDO;
import cn.sinjinsong.eshop.core.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/6.
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDOMapper mapper;
    @Transactional(readOnly = true)
    @Override
    public List<NewsDO> findAllNews() {
        return mapper.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public List<NewsDO> findLatestNews(Integer count) {
        return mapper.findLatest(count);
    }
    @Transactional
    @Override
    public void save(NewsDO news) {
        mapper.insert(news);
    }
    @Transactional
    @Override
    public void update(NewsDO news) {
        mapper.updateByPrimaryKeySelective(news);
    }
    @Transactional(readOnly = true)
    @Override
    public NewsDO findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
