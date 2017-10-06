package cn.sinjinsong.eshop.common.exception.file;

import cn.sinjinsong.eshop.common.exception.annotation.RESTField;
import cn.sinjinsong.eshop.common.exception.annotation.RESTResponseStatus;
import cn.sinjinsong.eshop.common.exception.base.BaseRESTException;
import org.springframework.http.HttpStatus;

/**
 * Created by SinjinSong on 2017/4/29.
 */
@RESTResponseStatus(value= HttpStatus.NOT_FOUND,code=3)
@RESTField("file")
public class FileNotFoundException extends BaseRESTException {
    public FileNotFoundException(String file){
        super(file);
    }
}
