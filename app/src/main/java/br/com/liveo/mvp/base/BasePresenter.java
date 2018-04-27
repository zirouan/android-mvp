package br.com.liveo.mvp.base;


import android.support.annotation.NonNull;

import br.com.liveo.mvp.main.MainPresenter;
import br.com.liveo.mvp.main.MainView;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by rudsonlima on 8/29/17.
 */

public abstract class BasePresenter<T extends MainView> implements MainPresenter<T> {

    private T mView;
    private BaseScheduler mScheduler;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(@NonNull BaseScheduler scheduler) {
        this.mScheduler = scheduler;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    protected BaseScheduler getScheduler() {
        return mScheduler;
    }

    protected void addDisposable(Disposable disposable) {
        this.mCompositeDisposable.add(disposable);
    }

    private void clearDisposables() {
        this.mCompositeDisposable.clear();
    }

    @Override
    public T getView() {
        return this.mView;
    }

    @Override
        public void attach(T view) {
            this.mView = view;
        }

    @Override
    public void detachView() {
        this.clearDisposables();
        this.mView = null;
    }
}