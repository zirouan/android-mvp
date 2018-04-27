package br.com.liveo.mvp.data.remote.helper;

import br.com.liveo.mvp.data.remote.endpoint.EndPoint;
import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.model.exception.ListException;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 10/9/17.
 */

public class HelperManager implements EndPointHelper {

    private EndPoint mEndPoint;

    public HelperManager(EndPoint endPoint) {
        this.mEndPoint = endPoint;
    }

    //region Methods User
    @Override
    public Single<UserResponse> fetchUsers(int page) {
        return (page > 0) ? this.mEndPoint.fetchUsers(page).map(
                HelperFunction.getUserResponseMapper(new ListException())).singleOrError() :
                Single.error(new ListException());
    }
    //endregion

}
