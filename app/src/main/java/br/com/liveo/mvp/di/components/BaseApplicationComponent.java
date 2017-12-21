package br.com.liveo.mvp.di.components;

import br.com.liveo.mvp.screen.home.di.HomeComponent;
import br.com.liveo.mvp.screen.home.di.HomeModule;

/**
 * Created by rudsonlima on 10/9/17.
 */

public interface BaseApplicationComponent {

    HomeComponent module(HomeModule homeModule);
}
