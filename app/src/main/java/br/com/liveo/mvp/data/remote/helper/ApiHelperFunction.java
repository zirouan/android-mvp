package br.com.liveo.mvp.data.remote.helper;

import android.support.annotation.NonNull;

import br.com.liveo.mvp.base.BaseException;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.model.exception.ListException;
import io.reactivex.functions.Function;

/**
 * Created by rudsonlima on 10/9/17.
 */

class ApiHelperFunction {

    @NonNull
    static Function<UserResponse, UserResponse>
    getUserResponseMapper(final BaseException exception) {
        return userResponse -> {
            if (userResponse != null && userResponse.errorMessage == null) {
                if (userResponse.list.size() == 0) {
                    exception.setCode(ListException.EMPTY_CODE);
                    throw exception;
                }
                return userResponse;
            }
            throw exception;
        };
    }
}
