package br.com.liveo.mvp.screen.home;

import br.com.liveo.mvp.base.BaseView;
import br.com.liveo.mvp.main.MainPresenter;
import br.com.liveo.mvp.model.domain.UserResponse;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        int getPage();
        void onUserResponse(UserResponse userResponse);
    }

    interface Presenter extends MainPresenter<View> {
        void fetchUsers();
    }

    interface Interactor {
        Observable<UserResponse> fetchUsers(int page);
    }
}
