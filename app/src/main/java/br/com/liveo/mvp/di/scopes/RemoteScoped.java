package br.com.liveo.mvp.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * This is a Dagger scope to identify RemoteScoped repository
 *
 * Created by rudsonlima on 8/31/17.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteScoped {
}
