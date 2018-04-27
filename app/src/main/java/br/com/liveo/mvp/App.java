package br.com.liveo.mvp;

import android.app.Application;

import java.lang.ref.WeakReference;

import br.com.liveo.mvp.di.components.BaseApplicationComponent;
import br.com.liveo.mvp.di.components.DaggerApplicationComponent;
import br.com.liveo.mvp.di.modules.HelperModule;

/**
 * Created by rudsonlima on 8/31/17.
 */

public class App extends Application {

    private BaseApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerApplicationComponent.builder()
                .helperModule(new HelperModule(new WeakReference<>(this)))
                .build();
    }

    public void setApp(BaseApplicationComponent appComponent) {
        this.appComponent = appComponent;
    }

    public BaseApplicationComponent getApp() {
        return appComponent;
    }
}
