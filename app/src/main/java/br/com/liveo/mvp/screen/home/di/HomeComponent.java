package br.com.liveo.mvp.screen.home.di;

import br.com.liveo.mvp.di.scopes.ActivityScoped;
import br.com.liveo.mvp.screen.home.HomeActivity;
import dagger.Subcomponent;

/**
 * Created by rudsonlima on 9/4/17.
 */
@ActivityScoped
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
