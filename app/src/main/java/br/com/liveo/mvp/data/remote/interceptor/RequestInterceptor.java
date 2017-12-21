package br.com.liveo.mvp.data.remote.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.liveo.mvp.data.local.PreferencesHelper;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rudsonlima on 10/2/17.
 */

@Singleton
public class RequestInterceptor implements Interceptor {

    private PreferencesHelper preferencesHelper;

    @Inject
    public RequestInterceptor(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request.Builder requestBuilder;
        requestBuilder = chain.request().newBuilder();
        requestBuilder.addHeader("Content-Type", "application/json");

        final String token = preferencesHelper.getToken();
        if (!TextUtils.isEmpty(token)) {
            requestBuilder.addHeader("token", token);
        }

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
