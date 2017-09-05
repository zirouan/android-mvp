package br.com.liveo.mvp;

import android.app.Application;

import br.com.liveo.mvp.di.components.ApplicationComponent;
import br.com.liveo.mvp.di.components.DaggerApplicationComponent;
import br.com.liveo.mvp.di.modules.NetworkModule;

/**
 * Created by rudsonlima on 8/31/17.
 */

public class App extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule()).build();
    }

    public ApplicationComponent getApp() {
        return appComponent;
    }
}
