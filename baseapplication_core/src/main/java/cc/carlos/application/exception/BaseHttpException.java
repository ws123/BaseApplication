package cc.carlos.application.exception;

/**
 * Created by carlos on 15/7/8.
 */
public class BaseHttpException extends RuntimeException{
    public BaseHttpException() {
        super();
    }

    public BaseHttpException(String detailMessage) {
        super(detailMessage);
    }

    public BaseHttpException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public BaseHttpException(Throwable throwable) {
        super(throwable);
    }
}
