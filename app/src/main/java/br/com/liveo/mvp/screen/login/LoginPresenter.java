package br.com.liveo.mvp.screen.login;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.liveo.mvp.base.BasePresenter;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(@NonNull BaseScheduler scheduler) {
        super(scheduler);
    }


    @Override
    public LoginContract.View getView() {
        return super.getView();
    }

    @Override
    public void toDoLogin() {

    }
}
