package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/29.
 */
@RESTResponseStatus(value= HttpStatus.BAD_REQUEST,code=6)
@RESTField("file")
public class FileDownloadException extends BaseRESTException {
    public FileDownloadException(String file){
        super(file);
    }
}
