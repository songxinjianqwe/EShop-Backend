package cn.sinjinsong.eshop.core.service.ad.impl;

import cn.sinjinsong.eshop.core.dao.ad.AdDOMapper;
import cn.sinjinsong.eshop.core.domain.entity.ad.AdDO;
import cn.sinjinsong.eshop.core.service.ad.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/11.
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdDOMapper mapper;
    @Override
    public List<AdDO> findAll() {
        return mapper.findAll();
    }
}
