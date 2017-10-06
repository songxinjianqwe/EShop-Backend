package cn.sinjinsong.eshop.core.exception.user;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/9.
 */
@RESTResponseStatus(value = HttpStatus.FORBIDDEN,code=1)
@RESTField("role")
public class AccessDeniedException extends BaseRESTException {
    public AccessDeniedException(String role){
        super(role);
    }
}
