package br.com.liveo.mvp.base;


import android.support.annotation.NonNull;

import br.com.liveo.mvp.main.MainPresenter;
import br.com.liveo.mvp.main.MainView;
import br.com.liveo.mvp.util.scheduler.BaseScheduler;

/**
 * Created by rudsonlima on 8/29/17.
 */

public abstract class BasePresenter<T extends MainView> implements MainPresenter<T> {

    private BaseScheduler mSchedulerProvider;

    public BasePresenter(@NonNull BaseScheduler scheduler) {
        this.mSchedulerProvider = scheduler;
    }

    protected BaseScheduler getSchedulerProvider() {
        return mSchedulerProvider;
    }
}