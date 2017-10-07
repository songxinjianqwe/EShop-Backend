package cn.sinjinsong.eshop.core.exception.pay;

import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/10/7.
 */
@RestResponseStatus(value = HttpStatus.BAD_REQUEST,code = 10)
public class DepositException extends BaseRestException {
    public DepositException(String amount){
        super(amount);
    }
}
