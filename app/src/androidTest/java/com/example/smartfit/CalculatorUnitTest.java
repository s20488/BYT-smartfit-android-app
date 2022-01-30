package com.example.smartfit;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.smartfit.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalculatorUnitTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldOutputResultOfBMIAndKCLCalculations() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnSignIn), withText("SIGN IN"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.root_element),
                                        2),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction materialEditText = onView(
                allOf(withId(R.id.emailField),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.cardview.widget.CardView")),
                                        0),
                                0),
                        isDisplayed()));
        materialEditText.perform(replaceText("qwerty@gmail.com"), closeSoftKeyboard());

        ViewInteraction materialEditText2 = onView(
                allOf(withId(R.id.passField),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.cardview.widget.CardView")),
                                        0),
                                1),
                        isDisplayed()));
        materialEditText2.perform(replaceText("qwerty"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("Sign in"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_choose_calculator), withText("Calorie calculator"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.motion.widget.MotionLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.radio1), withText("Kobieta"),
                        childAtPosition(
                                allOf(withId(R.id.genderCheck),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Age),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("19"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.hight),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("174"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.NumberWeight),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("56"), closeSoftKeyboard());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.Aktywosc1), withText("Niska"),
                        childAtPosition(
                                allOf(withId(R.id.Activity),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                0),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.NumberWeight), withText("56"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.saveButton), withText("Oblicz"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        appCompatButton4.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
