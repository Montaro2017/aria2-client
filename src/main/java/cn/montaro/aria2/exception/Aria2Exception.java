package cn.montaro.aria2.exception;

public class Aria2Exception extends RuntimeException {
    public Aria2Exception() {
    }

    public Aria2Exception(String message) {
        super(message);
    }

    public Aria2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Aria2Exception(Throwable cause) {
        super(cause);
    }

    public Aria2Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
