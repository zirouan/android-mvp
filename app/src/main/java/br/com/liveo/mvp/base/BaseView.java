package br.com.liveo.mvp.base;

import br.com.liveo.mvp.main.MainView;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface BaseView<T> extends MainView {
    void onLoading(boolean isLoading);

    void onError(String error);
}
