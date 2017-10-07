package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/29.
 */
@RestResponseStatus(value= HttpStatus.BAD_REQUEST,code=5)
@RestField("fileType")
public class FileTypeNotSuppertedException extends BaseRestException {
    public FileTypeNotSuppertedException(String type){
        super(type);
    }
}
