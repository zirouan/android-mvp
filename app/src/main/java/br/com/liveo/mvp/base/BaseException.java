package br.com.liveo.mvp.base;

/**
 * Created by rudsonlima on 10/10/17.
 */

public abstract class BaseException extends Exception {

    public static final int DEFAULT_CODE = -1;
    private int code = DEFAULT_CODE;

    public BaseException(String message) {
        super(message);
    }

    public BaseException() {

    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public abstract int getStringRes();
}
