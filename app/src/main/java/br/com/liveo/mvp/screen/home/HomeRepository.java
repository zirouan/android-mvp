package br.com.liveo.mvp.screen.home;

import javax.inject.Inject;

import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 9/4/17.
 */
public class HomeRepository implements HomeContract.Repository {
    private EndPointHelper endPointHelper;

    @Inject
    public HomeRepository(EndPointHelper endPointHelper) {
        this.endPointHelper = endPointHelper;
    }

    @Override
    public Single<UserResponse> fetchUsers(int page) {
        return this.endPointHelper.fetchUsers(page);
    }
}
