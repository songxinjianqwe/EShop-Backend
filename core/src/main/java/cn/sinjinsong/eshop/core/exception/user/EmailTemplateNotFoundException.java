package cn.sinjinsong.eshop.core.exception.user;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * @author songx
 * @date 2017/12/19
 */
@RestResponseStatus(value = HttpStatus.NOT_FOUND, code = 1)
@RestField("email")
public class EmailTemplateNotFoundException extends BaseRestException {
    public EmailTemplateNotFoundException(String email) {
        super(email);
    }
}
