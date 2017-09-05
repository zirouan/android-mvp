package br.com.liveo.mvp.screen.home;

import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import br.com.liveo.mvp.base.BasePresenter;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.util.Constant;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeInteractor mHomeInteractor;

    @Inject
    public HomePresenter(@NonNull HomeInteractor homeInteractor, @NonNull BaseScheduler scheduler) {
        super(scheduler);
        this.mHomeInteractor = homeInteractor;
    }

    @Override
    public void fetchUsers() {
        mView.onLoading(true);
        mHomeInteractor.fetchUsers(mView.getPage())
                .subscribeOn(this.getSchedulerProvider().io())
                .observeOn(this.getSchedulerProvider().ui())
                .subscribe(
                        this::sucess,//onNext
                        error -> error(error.getMessage()),//onError
                        () -> Log.i(Constant.TAG, "fetchUsers -> Success") //OnComplete
                );
    }

    private void error(String error){
        mView.onLoading(false);
        mView.onError(error);
    }

    private void sucess(UserResponse userResponse){
        mView.onLoading(false);
        mView.onUserResponse(userResponse);
    }

    @Override
    public void attach(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
