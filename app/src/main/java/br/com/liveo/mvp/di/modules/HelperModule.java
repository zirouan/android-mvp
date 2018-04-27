package br.com.liveo.mvp.di.modules;


import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import br.com.liveo.mvp.BuildConfig;
import br.com.liveo.mvp.data.local.Preferences;
import br.com.liveo.mvp.data.local.PreferencesHelper;
import br.com.liveo.mvp.data.remote.endpoint.EndPoint;
import br.com.liveo.mvp.data.remote.helper.HelperManager;
import br.com.liveo.mvp.data.remote.endpoint.EndPointHelper;
import br.com.liveo.mvp.data.remote.interceptor.RequestInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rudsonlima on 9/4/17.
 */
@Module
public class HelperModule {
    private static final int CONNECT_TIMEOUT_IN_MS = 60000;

    private final WeakReference<Context> mContext;

    public HelperModule(WeakReference<Context> context) {
        mContext = context;
    }

    @Provides
    @Singleton
    WeakReference<Context> provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Interceptor proviveRequestInterceptor(PreferencesHelper preferencesHelper) {
        return new RequestInterceptor(preferencesHelper);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(RequestInterceptor requestInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(requestInterceptor)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    EndPoint provideApiEndPoint(Retrofit retrofit) {
        return retrofit.create(EndPoint.class);
    }

    @Singleton
    @Provides
    EndPointHelper provideApiEndPointHelper(EndPoint endPoint) {
        return new HelperManager(endPoint);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(WeakReference<Context> context) {
        return new Preferences(context);
    }
}
