package south.girl.exception;

/**
 * 这里不继承Exception是因为spring 对exception是不做回滚操作的，所以继承RuntimeException
 * Created by zhang_w on 2018/2/4.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
