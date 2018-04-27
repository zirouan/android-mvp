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

    private HomeContract.Repository mRepository;

    @Inject
    public HomePresenter(@NonNull HomeContract.Repository repository,
                         @NonNull BaseScheduler scheduler) {
        super(scheduler);
        this.mRepository = repository;
    }

    @Override
    public void fetchUsers() {
        if (this.getView() != null) {
            this.getView().onLoading(true);

            this.addDisposable(mRepository.fetchUsers(this.getView().getPage()).
                    subscribeOn(this.getScheduler().io())
                    .observeOn(this.getScheduler().ui())
                    .subscribe(

                            userResponse -> {//onSuccess
                                this.getView().onLoading(false);
                                this.getView().onUserResponse(userResponse);
                            },

                            error -> {
                                this.getView().onLoading(false);
                                this.getView().onError(error);
                            }
                    ));
        }
    }

    @Override
    public HomeContract.View getView() {
        return super.getView();
    }
}
