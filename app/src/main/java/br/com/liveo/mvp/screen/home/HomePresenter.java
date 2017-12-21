package br.com.liveo.mvp.screen.home;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.liveo.mvp.base.BasePresenter;
import br.com.liveo.mvp.screen.home.di.HomeModule;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;

/**
 * This class makes module for {@link HomeModule}
 *
 * @author Rudson Lima
 * @since 10/02/17
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
        if (this.getView() != null) {
            this.getView().onLoading(true);

            this.mInteractor.fetchUsers(this.mView.getPage()).
                    subscribeOn(this.getSchedulerProvider().io())
                    .observeOn(this.getSchedulerProvider().ui())
                    .subscribe(

                            userResponse -> {//onSuccess
                                this.getView().onLoading(false);
                                this.getView().onUserResponse(userResponse);
                            },

                            error -> {
                                this.getView().onLoading(false);
                                this.getView().onError(error);
                            }
                    );
        }
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
    public HomeContract.View getView() {
        return this.mView;
    }
}
