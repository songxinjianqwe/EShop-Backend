package cn.sinjinsong.eshop.core.exception.token;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/28.
 */
@RestResponseStatus(value = HttpStatus.UNAUTHORIZED,code = 3)
@RestField("userStatus")
public class UserStatusInvalidException extends BaseRestException {
    public UserStatusInvalidException(String userStatus){
        super(userStatus);
    }
}
