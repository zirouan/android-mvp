package br.com.liveo.mvp.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * This is a Dagger scope for identify each activity scope
 *
 * Created by rudsonlima on 8/31/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}

