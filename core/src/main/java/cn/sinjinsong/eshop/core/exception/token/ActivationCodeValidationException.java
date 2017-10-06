package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/28.
 */
@RESTResponseStatus(value = HttpStatus.UNAUTHORIZED,code =3)
@RESTField("activationCode")
public class ActivationCodeValidationException extends BaseRESTException {
    public ActivationCodeValidationException(String activationCode){
        super(activationCode);
    }
}
