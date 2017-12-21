package br.com.liveo.mvp.screen.login;

import br.com.liveo.mvp.base.BaseView;
import br.com.liveo.mvp.main.MainPresenter;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        String getEmail();
        String getPassword();
        void onLoginSuccess();
    }

    interface Presenter extends MainPresenter<View> {
        void toDoLogin();
    }
}
