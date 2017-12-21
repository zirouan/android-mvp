package br.com.liveo.mvp.model.exception;

import br.com.liveo.mvp.R;
import br.com.liveo.mvp.base.BaseException;

/**
 * Created by rudsonlima on 10/10/17.
 */

public class LoginException extends BaseException {

    public static final int EMPTY_EMAIL_CODE = 0;
    public static final int EMPTY_PASSWORD_CODE = 1;
    public static final int EMAIL_VALID_CODE = 2;

    @Override
    public int getStringRes() {
        int code = getCode();
        switch (code) {
            case EMPTY_EMAIL_CODE:
                return R.string.enter_the_your_email;
            case EMPTY_PASSWORD_CODE:
                return R.string.enter_the_your_password;
            case EMAIL_VALID_CODE:
                return R.string.enter_the_your_email_valid;
        }
        return DEFAULT_CODE;
    }
}