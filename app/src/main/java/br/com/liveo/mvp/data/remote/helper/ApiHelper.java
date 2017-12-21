package br.com.liveo.mvp.data.remote.helper;

import br.com.liveo.mvp.data.remote.EndPoint;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.model.exception.ListException;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 10/9/17.
 */

public class ApiHelper implements EndPointHelper {

    private EndPoint mEndPoint;

    public ApiHelper(EndPoint endPoint) {
        this.mEndPoint = endPoint;
    }

    //region Methods User
    @Override
    public Single<UserResponse> fetchUsers(int page) {
        return (page > 0) ? this.mEndPoint.fetchUsers(page).map(
                ApiHelperFunction.getUserResponseMapper(new ListException())).singleOrError() :
                Single.error(new ListException());
    }
    //endregion

}
