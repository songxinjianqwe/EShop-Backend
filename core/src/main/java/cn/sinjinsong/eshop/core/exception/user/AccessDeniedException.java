package cn.sinjinsong.eshop.core.exception.user;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/5/9.
 */
@RestResponseStatus(value = HttpStatus.FORBIDDEN,code=1)
@RestField("role")
public class AccessDeniedException extends BaseRestException {
    public AccessDeniedException(String role){
        super(role);
    }
}
