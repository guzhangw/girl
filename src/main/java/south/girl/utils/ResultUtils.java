package south.girl.utils;

import south.girl.entity.Result;

/**
 * Created by zhang_w on 2018/2/4.
 */
public class ResultUtils {
    public static Result success(Object object){
        Result result = new Result();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }


    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
