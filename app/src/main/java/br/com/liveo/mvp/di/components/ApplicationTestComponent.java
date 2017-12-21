package br.com.liveo.mvp.di.components;

import javax.inject.Singleton;

import br.com.liveo.mvp.di.modules.HelperTestModule;
import dagger.Component;

/**
 * Created by rudsonlima on 9/2/17.
 */

@Singleton
@Component(modules = {HelperTestModule.class})
public interface ApplicationTestComponent extends BaseApplicationComponent {
}
