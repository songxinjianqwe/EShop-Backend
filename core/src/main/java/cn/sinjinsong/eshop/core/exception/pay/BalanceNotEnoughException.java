package cn.sinjinsong.eshop.core.exception.pay;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/10/7.
 */
@RestResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,code = 1)
@RestField("balance")
public class BalanceNotEnoughException extends BaseRestException{
    public BalanceNotEnoughException(String balance){
        super(balance);
    }
}
