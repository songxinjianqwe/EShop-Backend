package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/29.
 */
@RestResponseStatus(value= HttpStatus.NOT_FOUND,code=3)
@RestField("file")
public class FileNotFoundException extends BaseRestException {
    public FileNotFoundException(String file){
        super(file);
    }
}
