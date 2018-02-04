package south.girl.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import south.girl.entity.Result;
import south.girl.exception.GirlException;
import south.girl.utils.ResultUtils;

/**
 * Created by zhang_w on 2018/2/4.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            return ResultUtils.error(100,e.getMessage());
        }else{
            return ResultUtils.error(-1,"未知错误");
        }
    }
}
