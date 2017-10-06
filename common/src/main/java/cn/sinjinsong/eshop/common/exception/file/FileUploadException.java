package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/28.
 */
@RESTResponseStatus(value= HttpStatus.BAD_REQUEST,code=4)
@RESTField("file")
public class FileUploadException extends BaseRESTException {
    public FileUploadException(String fileName){
        super(fileName);
    }
}
