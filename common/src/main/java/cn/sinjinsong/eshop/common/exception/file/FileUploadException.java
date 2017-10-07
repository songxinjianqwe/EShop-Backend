package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RestField;
import cn.sinjinsong.eshop.common.exception.annotation.RestResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRestException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/28.
 */
@RestResponseStatus(value= HttpStatus.BAD_REQUEST,code=4)
@RestField("file")
public class FileUploadException extends BaseRestException {
    public FileUploadException(String fileName){
        super(fileName);
    }
}
