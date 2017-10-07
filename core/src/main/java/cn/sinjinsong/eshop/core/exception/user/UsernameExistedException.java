package cn.sinjinsong.eshop.core.exception.user;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

@RestResponseStatus(value = HttpStatus.CONFLICT, code = 1)
@RestField("name")
public class UsernameExistedException extends BaseRestException {
    public UsernameExistedException(String name) {
        super(name);
    }

}
