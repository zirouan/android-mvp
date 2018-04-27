package br.com.liveo.mvp.main;

/**
 * Created by rudsonlima on 8/29/17.
 */

public interface MainPresenter<T> {
    void attach(T view);

    void detachView();

    T getView();
}
