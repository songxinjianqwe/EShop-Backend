package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/7.
 */
@RestResponseStatus(value= HttpStatus.UNAUTHORIZED,code=4)
@RestField("tokenStatus")
public class TokenStateInvalidException extends BaseRestException {
    public TokenStateInvalidException(String tokenStatus){
        super(tokenStatus);
    }
}
