package br.com.liveo.mvp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import br.com.liveo.mvp.di.components.ApplicationTestComponent;
import br.com.liveo.mvp.di.components.DaggerApplicationTestComponent;
import br.com.liveo.mvp.di.modules.HelperTestModule;

public class ApplicationTestComponentRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        HelperTestModule helperTestModule = new HelperTestModule();

        module(helperTestModule);

        return base;
    }

    static void module(HelperTestModule helperTestModule) {

        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        App app4Adviser = (App) context.getApplicationContext();

        ApplicationTestComponent baseComponent = DaggerApplicationTestComponent.builder()
                .helperTestModule(helperTestModule)
                .build();

        app4Adviser.setApp(baseComponent);
    }
}
