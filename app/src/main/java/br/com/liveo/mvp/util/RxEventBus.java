package br.com.liveo.mvp.util;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Rudson Lima on 11/9/17.
 */

public class RxEventBus {

    private static RxEventBus instance;
    public static RxEventBus newInstance() {
        if (instance == null) {
            instance = new RxEventBus();
        }
        return instance;
    }

    private PublishSubject<Object> eventBus = PublishSubject.create();

    public void send(Object o) {
        eventBus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return eventBus;
    }
}