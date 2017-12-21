package br.com.liveo.mvp.model.exception;

import br.com.liveo.mvp.R;
import br.com.liveo.mvp.base.BaseException;

/**
 * Created by rudsonlima on 10/10/17.
 */

public class ListException extends BaseException {

    public static final int EMPTY_CODE = 0;

    @Override
    public int getStringRes() {
        if (getCode() == EMPTY_CODE) {
            return R.string.warning_no_data;
        }

        return DEFAULT_CODE;
    }
}
