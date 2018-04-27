package br.com.liveo.mvp.screen.home.di;

import android.support.annotation.NonNull;

import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.di.scopes.ActivityScoped;
import br.com.liveo.mvp.screen.home.HomeContract;
import br.com.liveo.mvp.screen.home.HomeRepository;
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
    HomeContract.Repository provideHomeRepository(@NonNull EndPointHelper apiEndPointHelper) {
        return new HomeRepository(apiEndPointHelper);
    }

    @Provides
    @ActivityScoped
    HomeContract.Presenter provideHomePresenter(@NonNull HomeContract.Repository repository,
                                                @NonNull BaseScheduler scheduler) {
        return new HomePresenter(repository, scheduler);
    }

    @Provides
    BaseScheduler provideSchedulerProvider() {
        return InjectionScheduler.schedulerProvider();
    }
}
