package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import cn.sinjinsong.eshop.core.domain.dto.user.LoginDTO;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/27.
 */
@RestResponseStatus(value = HttpStatus.UNAUTHORIZED, code = 1)
@RestField("loginInfo")
public class LoginInfoInvalidException extends BaseRestException {
    public LoginInfoInvalidException(LoginDTO loginDTO) {
        super(loginDTO);
    }
}
