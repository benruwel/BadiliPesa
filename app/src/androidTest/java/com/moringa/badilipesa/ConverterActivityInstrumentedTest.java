package com.moringa.badilipesa;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ConverterActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<ConverterActivity> activityTestRule =
            new ActivityTestRule<>(ConverterActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.amountToConvert)).perform(typeText("500"))
                .check(matches(withText("500")));
    }

    @Test
    public void convertedAmountDisplayedCorrectly() {
        String amountToConvert = "500";
        onView(withId(R.id.amountToConvert)).perform(typeText("500")).perform(closeSoftKeyboard());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.conversionButton)).perform(click());
        onView(withId(R.id.convertedString)).check(matches(
                withText(String.format("To KSH %s", amountToConvert))
        ));
    }
}









