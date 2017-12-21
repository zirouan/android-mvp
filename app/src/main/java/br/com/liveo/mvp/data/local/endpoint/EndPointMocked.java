package br.com.liveo.mvp.data.local.endpoint;

import br.com.liveo.mvp.data.remote.EndPoint;
import br.com.liveo.mvp.model.constant.LoginConstant;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class EndPointMocked implements EndPoint {

    private String mEmail;
    private String mPassword;

    public EndPointMocked() {
        this(LoginConstant.EMAIL, LoginConstant.PASSWORD);
    }

    public EndPointMocked(String email, String password) {
        this.mEmail = email;
        this.mPassword = password;
    }

    @Override
    public Observable<UserResponse> fetchUsers(int page) {
        return null;
    }
}
