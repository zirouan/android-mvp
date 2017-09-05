package br.com.liveo.mvp.util.scheduler;

/**
 * Created by rudsonlima on 8/29/17.
 */
public class InjectionScheduler {

    public static BaseScheduler schedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}
