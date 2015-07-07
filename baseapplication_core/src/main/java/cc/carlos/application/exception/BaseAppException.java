package cc.carlos.application.exception;

/**
 * Created by zhangheilong on 15/7/7.
 */
public class BaseAppException extends RuntimeException{
    public BaseAppException() {
        super();
    }

    public BaseAppException(String detailMessage) {
        super(detailMessage);
    }

    public BaseAppException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public BaseAppException(Throwable throwable) {
        super(throwable);
    }
}
