package cn.sinjinsong.eshop.core.exception.pay;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/10/14.
 */
@RestResponseStatus(value= HttpStatus.FORBIDDEN,code=2)
@RestField("username")
public class PaymentPasswordInCorrectException extends BaseRestException{
    public PaymentPasswordInCorrectException(String username){
        super(username);
    }
}
