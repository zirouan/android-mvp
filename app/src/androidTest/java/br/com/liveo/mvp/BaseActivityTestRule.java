package br.com.liveo.mvp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.UiDevice;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import org.hamcrest.Matcher;

import java.lang.ref.WeakReference;

import br.com.liveo.mvp.di.modules.HelperTestModule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Created by rudsonlima on 10/3/17.
 */

public abstract class BaseActivityTestRule {

    private WeakReference<Context> mContext;
    private HelperTestModule mHelperTestModule;

    protected void onInitHelperTestModule() {
        mContext = new WeakReference<>(InstrumentationRegistry.getTargetContext());

        mHelperTestModule = new HelperTestModule(mContext);
        ApplicationTestComponentRule.module(mHelperTestModule);

        getActivityTestRule().launchActivity(getIntent());
    }

    private Intent getIntent() {
        return new Intent();
    }

    protected void assertToast(@StringRes int stringResource) {
        onView(withText(stringResource)).inRoot(RootMatchers.withDecorView(
                not(is(getActivityTestRule().getActivity().getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    protected void performAction(@IdRes int resourceId, ViewAction viewAction) {
        onView(withId(resourceId)).perform(viewAction);
    }

    protected void performClick(int resourceId) {
        onView(withId(resourceId)).perform(click());
    }

    protected void performTextClick(int resourceId) {
        onView(allOf(withText(resourceId), isDisplayed())).perform(click());
    }

    protected void performClick(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)),
                isDisplayed())).perform(click());
    }

    protected void performClick(int resourceId, int resourceIdwithParentAllOf, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(allOf(withId(resourceIdwithParentAllOf),
                        withParent(withId(resourceIdwithParent)))),
                isDisplayed())).perform(click());
    }

    protected void performItemClick(@IdRes int resourceId) {
        onView(allOf(withId(resourceId),
                isDisplayed()))
                .perform(actionOnItemAtPosition(0, click()));
    }

    protected void performSwipeLeft(int resourceId) {
        onView(withId(resourceId)).perform(swipeLeft());
    }

    protected void performSwipeLeft(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)),
                isDisplayed())).perform(swipeLeft());
    }

    protected void performSwipeRight(int resourceId) {
        onView(withId(resourceId)).perform(swipeRight());
    }

    protected void performSwipeRight(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)),
                isDisplayed())).perform(swipeRight());
    }

    protected void performSwipeUp(int resourceId) {
        onView(withId(resourceId)).perform(swipeUp());
    }

    protected void performSwipeUp(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)),
                isDisplayed())).perform(swipeUp());
    }

    protected void performSwipeDown(int resourceId) {
        onView(withId(resourceId)).perform(swipeDown());
    }

    protected void performSwipeDown(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)),
                isDisplayed())).perform(swipeDown());
    }

    protected void performClickImeAction(int resourceId) {
        onView(withId(resourceId)).perform(pressImeActionButton());
    }

    protected void performClickImeActionScrollTo(int resourceId) {
        onView(withId(resourceId)).perform(scrollTo(), pressImeActionButton());
    }

    protected void performTypeText(int resourceId, String text) {
        onView(withId(resourceId)).perform(typeText(text),
                closeSoftKeyboard());
    }

    protected void performTypeTextNotCloseSoftKeyboard(int resourceId, String text) {
        onView(withId(resourceId)).perform(typeText(text));
    }

    // Performs text insert where the parent necessarily is ScrollView
    //
    // View preconditions:
    // must be a descendant of ScrollView
    // must have visibility set to View.VISIBLE
    protected void performTypeTextScrollTo(int resourceId, String text) {
        onView(withId(resourceId)).perform(scrollTo(), typeText(text),
                closeSoftKeyboard());
    }

    protected void performClickScrollTo(int resourceId) {
        onView(withId(resourceId)).perform(scrollTo(), click());
    }

    //android.R.string.ok
    protected void performClickScrollToWithTextOK(int resourceId) {
        onView(allOf(withId(resourceId), withText(android.R.string.ok))).perform(scrollTo(), click());
    }

    //android.R.string.cancel
    protected void performClickScrollToWithTextCancel(int resourceId) {
        onView(allOf(withId(resourceId), withText(android.R.string.cancel))).perform(scrollTo(), click());
    }

    protected void performTypeTextScrollToNotCloseSoftKeyboard(int resourceId, String text) {
        onView(withId(resourceId)).perform(scrollTo(), typeText(text));
    }

    protected void pressDeviceBack() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressBack();
    }

    protected void pressHomeBack() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).pressHome();
    }

    protected void performPressBack() {
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    protected void performBackToolbar() {
        onView(allOf(backToolbarMatcher(),
                withParent(withId(R.id.toolbar)),
                isDisplayed())).perform(click());
    }

    //Checks if the view is visible on the screen
    protected void checkMatchesIsDisplayed(int resourceId) {
        onView(withId(resourceId)).check(matches(isDisplayed()));
    }

    protected void checkMatchesIsDisplayed(int resourceId, int resourceIdwithParent) {
        onView(allOf(withId(resourceId),
                withParent(withId(resourceIdwithParent)))).check(matches(isDisplayed()));
    }

    //Search on screen, a view that contains the text
    //Checks if the view is visible on the screen
    protected void checkMatchesIsDisplayed(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }

    /* Checks if the view is visible on the screen
       View preconditions:
       must be a descendant of ScrollView
       must have visibility set to View.VISIBLE */
    protected void checkMatchesIsDisplayedScrollTo(int resourceId) {
        onView(withId(resourceId)).perform(scrollTo(),
                closeSoftKeyboard()).check(matches(isDisplayed()));
    }

    //Checks if the view is not visible on the screen
    protected void checkMatchesNotIsDisplayed(int resourceId) {
        onView(withId(resourceId)).check(matches(not(isDisplayed())));
    }

    private static Matcher<View> backToolbarMatcher() {
        return allOf(
                withParent(withClassName(is(Toolbar.class.getName()))),
                withClassName(anyOf(
                        is(ImageButton.class.getName()),
                        is(AppCompatImageButton.class.getName())
                )));
    }

    protected static BaseViewAction onItemClick(final int id) {
        return new BaseViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                view.findViewById(id).performClick();
            }
        };
    }

    public WeakReference<Context> getContext() {
        return mContext;
    }

    public String getString(@StringRes int resId){
        return getActivityTestRule().getActivity().getString(resId);
    }

    protected HelperTestModule getHelperTestModule() {
        return mHelperTestModule;
    }

    protected abstract ActivityTestRule getActivityTestRule();
}
