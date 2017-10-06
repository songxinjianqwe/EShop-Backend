package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/7.
 */
@RESTResponseStatus(value= HttpStatus.UNAUTHORIZED,code=4)
@RESTField("tokenStatus")
public class TokenStateInvalidException extends BaseRESTException {
    public TokenStateInvalidException(String tokenStatus){
        super(tokenStatus);
    }
}
