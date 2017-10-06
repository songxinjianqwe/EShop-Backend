package cn.sinjinsong.eshop.core.security.login;


import cn.sinjinsong.eshop.core.domain.dto.user.LoginDTO;
import cn.sinjinsong.eshop.core.domain.entity.user.UserDO;

/**
 * Created by SinjinSong on 2017/5/7.
 */
public interface LoginHandler {
    UserDO handle(LoginDTO loginDTO);
}
