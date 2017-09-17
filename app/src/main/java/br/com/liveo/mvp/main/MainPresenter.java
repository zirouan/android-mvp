package br.com.liveo.mvp.main;

import br.com.liveo.mvp.base.BaseView;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface MainPresenter<T> {
    void attach(T view);
    void detachView();
    BaseView getView();
}
