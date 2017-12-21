package br.com.liveo.mvp.screen.home;

import javax.inject.Inject;

import br.com.liveo.mvp.data.remote.helper.EndPointHelper;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 9/4/17.
 */
public class HomeInteractor implements HomeContract.Interactor {
    private EndPointHelper apiEndPointHelper;

    @Inject
    public HomeInteractor(EndPointHelper apiEndPointHelper) {
        this.apiEndPointHelper = apiEndPointHelper;
    }

    @Override
    public Single<UserResponse> fetchUsers(int page) {
        return this.apiEndPointHelper.fetchUsers(page);
    }
}
