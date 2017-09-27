package br.com.liveo.mvp.screen.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.liveo.mvp.base.BaseActivity;

/**
 * Created by rudsonlima on 9/1/17.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onLoading(boolean isLoading) {

    }

    @Override
    public void onError(Throwable error) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFailed(Throwable exception) {

    }
}
