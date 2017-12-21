package br.com.liveo.mvp;

import android.app.Application;

import java.lang.ref.WeakReference;

import br.com.liveo.mvp.di.components.ApplicationComponent;
import br.com.liveo.mvp.di.components.DaggerApplicationComponent;
import br.com.liveo.mvp.di.modules.HelperModule;

/**
 * Created by rudsonlima on 8/31/17.
 */

public class App extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerApplicationComponent.builder()
                .helperModule(new HelperModule(new WeakReference<>(this)))
                .build();
    }

    public ApplicationComponent getApp() {
        return appComponent;
    }
}
