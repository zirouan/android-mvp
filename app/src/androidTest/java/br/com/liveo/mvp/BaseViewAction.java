package br.com.liveo.mvp;

import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

/**
 * Created by Everdes Soares on 10/8/2017.
 */

public abstract class BaseViewAction implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return isAssignableFrom(View.class);
    }

    @Override
    public String getDescription() {
        return "View is not type " + View.class;
    }
}
