package br.com.liveo.mvp.data.local.endpoint;

import com.google.gson.Gson;

import br.com.liveo.mvp.data.remote.endpoint.EndPoint;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;

/**
 * Created by rudsonlima on 8/29/17.
 */

public class EndPointMocked implements EndPoint {


    public EndPointMocked() {
    }

    @Override
    public Observable<UserResponse> fetchUsers(int page) {
        return Observable.just(new Gson().fromJson(page != -1 ? EndPointJson.USERS_JSON_SUCCESS
                : EndPointJson.USERS_JSON_FAIL, UserResponse.class));
    }
}
