package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import cn.sinjinsong.eshop.core.domain.dto.user.LoginDTO;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/27.
 */
@RESTResponseStatus(value = HttpStatus.UNAUTHORIZED, code = 1)
@RESTField("loginInfo")
public class LoginInfoInvalidException extends BaseRESTException {
    public LoginInfoInvalidException(LoginDTO loginDTO) {
        super(loginDTO);
    }
}
