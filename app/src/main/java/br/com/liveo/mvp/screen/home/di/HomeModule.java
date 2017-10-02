package br.com.liveo.mvp.screen.home.di;

import android.support.annotation.NonNull;

import br.com.liveo.mvp.data.remote.ApiEndPoint;
import br.com.liveo.mvp.di.scopes.ActivityScoped;
import br.com.liveo.mvp.screen.home.HomeContract;
import br.com.liveo.mvp.screen.home.HomeInteractor;
import br.com.liveo.mvp.screen.home.HomePresenter;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;
import br.com.liveo.mvp.util.scheduler.InjectionScheduler;
import dagger.Module;
import dagger.Provides;

/**
 * This class makes Subcomponent for {@link HomeComponent}
 *
 * @author Rudson Lima
 * @since 10/02/17
 */

@Module
public class HomeModule {

    @Provides
    @ActivityScoped
    HomeContract.Interactor provideHomeInteractor(@NonNull ApiEndPoint apiEndPoint){
        return new HomeInteractor(apiEndPoint);
    }

    @Provides
    @ActivityScoped
    HomeContract.Presenter provideHomePresenter(@NonNull HomeContract.Interactor interactor,
                                                @NonNull BaseScheduler scheduler) {
        return new HomePresenter(interactor, scheduler);
    }

    @Provides
    BaseScheduler provideScheduleProvider() {
        return InjectionScheduler.schedulerProvider();
    }
}
