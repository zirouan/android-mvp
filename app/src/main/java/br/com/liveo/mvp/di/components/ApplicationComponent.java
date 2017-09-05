package br.com.liveo.mvp.di.components;

import javax.inject.Singleton;

import br.com.liveo.mvp.di.modules.NetworkModule;
import br.com.liveo.mvp.screen.home.di.HomeComponent;
import br.com.liveo.mvp.screen.home.di.HomeModule;
import dagger.Component;

/**
 * Created by rudsonlima on 9/2/17.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface ApplicationComponent {
    HomeComponent module(HomeModule detailsModule);
}
