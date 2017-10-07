package cn.sinjinsong.eshop.core.exception.mail;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/9.
 */
@RestResponseStatus(value= HttpStatus.NOT_FOUND,code=10)
@RestField("sender")
public class MailReceiverNotFoundException extends BaseRestException {
    public MailReceiverNotFoundException(Long sender){
        super(sender);
    }
}
