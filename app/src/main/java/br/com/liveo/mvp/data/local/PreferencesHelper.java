package br.com.liveo.mvp.data.local;

public interface PreferencesHelper {

    String getToken();
    void clearToken();
    void saveToken(String token);
}
