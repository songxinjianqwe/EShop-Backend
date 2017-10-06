package cn.sinjinsong.eshop.core.exception.mail;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/5.
 */
@RESTResponseStatus(value= HttpStatus.NOT_FOUND,code=7)
@RESTField("targetId")
public class MailStatusNotFoundException extends BaseRESTException {
    public MailStatusNotFoundException(Long targetId){
        super(targetId);
    }
}
