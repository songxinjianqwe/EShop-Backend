package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/27.
 */
@RestResponseStatus(value = HttpStatus.UNAUTHORIZED, code = 2)
@RestField("captcha")
public class CaptchaValidationException extends BaseRestException {
    public CaptchaValidationException(String value){
        super(value);
    }
}
