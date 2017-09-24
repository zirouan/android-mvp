package br.com.liveo.mvp.util.scheduler;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

public class TestSchedulerProvider implements BaseScheduler {
    private final TestScheduler mTestScheduler;

    public TestSchedulerProvider(TestScheduler testScheduler) {
        mTestScheduler = testScheduler;
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return mTestScheduler;
    }

    @NonNull
    @Override
    public Scheduler io() {
        return mTestScheduler;
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return mTestScheduler;
    }
}
