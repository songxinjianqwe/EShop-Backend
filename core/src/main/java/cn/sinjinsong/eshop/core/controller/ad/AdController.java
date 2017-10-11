package cn.sinjinsong.eshop.core.controller.ad;

import cn.sinjinsong.eshop.core.domain.entity.ad.AdDO;
import cn.sinjinsong.eshop.core.service.ad.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SinjinSong on 2017/10/11.
 */
@RestController
@RequestMapping("/ads")
@Slf4j
public class AdController {
    @Autowired
    private AdService adService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<AdDO> findAll(){
        return adService.findAll();    
    }
}
