package cn.sinjinsong.eshop.core.exception.user;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

@RESTResponseStatus(value = HttpStatus.CONFLICT, code = 1)
@RESTField("name")
public class UsernameExistedException extends BaseRESTException {
    public UsernameExistedException(String name) {
        super(name);
    }

}
