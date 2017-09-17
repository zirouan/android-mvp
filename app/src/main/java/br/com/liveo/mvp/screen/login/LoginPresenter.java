package br.com.liveo.mvp.screen.login;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.liveo.mvp.base.BasePresenter;
import br.com.liveo.mvp.base.BaseView;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.View mView;

    @Inject
    public LoginPresenter(@NonNull BaseScheduler scheduler) {
        super(scheduler);
    }


    @Override
    public void attach(LoginContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public BaseView getView() {
        return this.mView;
    }

    @Override
    public void toDoLogin() {

    }
}
