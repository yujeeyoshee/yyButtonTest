package com.example.cs.yybuttontest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.cs.yybuttontest", appContext.getPackageName());
    }

    @Test
    public void clickButtonTest() throws Exception {
        Espresso.onView(withId(R.id.textView)).check(matches(withText("Hello World!")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textView)).check(matches(withText("Button clicked 1 time")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withId(R.id.textView)).check(matches(withText("Button clicked 2 times")));
    }
}
