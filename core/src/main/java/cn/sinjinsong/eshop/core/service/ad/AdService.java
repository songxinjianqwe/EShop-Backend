package cn.sinjinsong.eshop.core.service.ad;

import cn.sinjinsong.eshop.core.domain.entity.ad.AdDO;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/11.
 */
public interface AdService {
    List<AdDO> findAll();
}
