package br.com.liveo.mvp.screen;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.liveo.mvp.BaseActivityTestRule;
import br.com.liveo.mvp.R;
import br.com.liveo.mvp.screen.home.HomeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

/**
 * This class makes activity for {@link HomeActivity}
 *
 * @author Rudson Lima
 * @since 10/02/17
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest extends BaseActivityTestRule {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule =
            new ActivityTestRule<>(HomeActivity.class, true, false);

    @Before
    public void setUp(){
        this.onInitHelperTestModule();
    }


    @Test
    public void onItemClick_zeroSuccess() {
        onView(allOf(withId(R.id.recycler_view),
                withParent(withId(R.id.swipe_container)),
                isDisplayed())).perform(actionOnItemAtPosition(0, click()));
    }

    @Test
    public void onItemClick_oneSuccess() {
        onView(allOf(withId(R.id.recycler_view),
                withParent(withId(R.id.swipe_container)),
                isDisplayed())).perform(actionOnItemAtPosition(1, click()));
    }

    @Test
    public void onItemClick_twoSuccess() {
        onView(allOf(withId(R.id.recycler_view),
                withParent(withId(R.id.swipe_container)),
                isDisplayed())).perform(actionOnItemAtPosition(2, click()));
    }

    @Override
    protected ActivityTestRule getActivityTestRule() {
        return mActivityTestRule;
    }
}
