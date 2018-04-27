package br.com.liveo.mvp.di.modules;


import android.content.Context;

import java.lang.ref.WeakReference;

import javax.inject.Singleton;

import br.com.liveo.mvp.data.local.Preferences;
import br.com.liveo.mvp.data.local.PreferencesHelper;
import br.com.liveo.mvp.data.local.endpoint.EndPointMocked;
import br.com.liveo.mvp.data.remote.endpoint.EndPoint;
import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.data.remote.helper.HelperManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by rudsonlima on 9/4/17.
 */
@Module
public class HelperTestModule {

    private EndPoint endPoint;
    private PreferencesHelper preferencesHelper;

    public HelperTestModule() {
        this.endPoint = new EndPointMocked();
    }

    public HelperTestModule(WeakReference<Context> context) {
        this.endPoint = new EndPointMocked();
        this.preferencesHelper = new Preferences(context);
    }

    @Singleton
    @Provides
    PreferencesHelper providePreferencesHelper() {
        return this.preferencesHelper;
    }

    @Singleton
    @Provides
    EndPoint provideApiEndPoint() {
        return this.endPoint;
    }

    @Singleton
    @Provides
    EndPointHelper provideApiEndPointHelper(EndPoint endPoint) {
        return new HelperManager(endPoint);
    }

    public PreferencesHelper getPreferencesHelper() {
        return preferencesHelper;
    }
}
