package br.com.liveo.mvp.screen.home;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import br.com.liveo.mvp.base.BasePresenter;
import br.com.liveo.mvp.base.BaseView;
import br.com.liveo.mvp.model.domain.UserResponse;
import br.com.liveo.mvp.util.Constant;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private HomeContract.View mView;

    private HomeContract.Interactor mInteractor;

    @Inject
    public HomePresenter(@NonNull HomeContract.Interactor interactor,
                         @NonNull BaseScheduler scheduler) {
        super(scheduler);
        this.mInteractor = interactor;
    }

    @Override
    public void fetchUsers() {
        this.mInteractor.fetchUsers(this.mView.getPage()).
                subscribeOn(this.getSchedulerProvider().io())
                .observeOn(this.getSchedulerProvider().ui())
                .subscribe(new SingleObserver<UserResponse>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        mView.onLoading(true);
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull UserResponse response) {
                        mView.onLoading(false);
                        mView.onUserResponse(response);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable error) {
                        mView.onLoading(false);
                        mView.onError(error);
                    }
                });
    }

    @Override
    public void attach(HomeContract.View view) {
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
}
