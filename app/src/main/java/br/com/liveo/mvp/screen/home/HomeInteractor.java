package br.com.liveo.mvp.screen.home;

import javax.inject.Inject;

import br.com.liveo.mvp.data.source.remote.ApiEndPoint;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;

/**
 * Created by rudsonlima on 9/4/17.
 */
public class HomeInteractor implements HomeContract.Interactor {
    private ApiEndPoint apiEndPoint;

    @Inject
    public HomeInteractor(ApiEndPoint apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
    }

    @Override
    public Observable<UserResponse> fetchUsers(int page) {
        return apiEndPoint.fetchUsers(page);
    }
}
