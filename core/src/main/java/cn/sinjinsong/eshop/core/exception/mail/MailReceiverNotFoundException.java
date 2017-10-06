package cn.sinjinsong.eshop.core.exception.mail;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/9.
 */
@RESTResponseStatus(value= HttpStatus.NOT_FOUND,code=10)
@RESTField("sender")
public class MailReceiverNotFoundException extends BaseRESTException {
    public MailReceiverNotFoundException(Long sender){
        super(sender);
    }
}
