package com.moringa.badilipesa;

import android.content.Intent;
import android.widget.TextView;

import com.moringa.badilipesa.ui.CurrenciesListActivity;
import com.moringa.badilipesa.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView introText = activity.findViewById(R.id.textView3);
        assertTrue("...the currency converter that you urgently needed".equals(introText.getText().toString()));
    }

    @Test
    public void currenciesActivityStarted() {
        activity.findViewById(R.id.buttonLogin).performClick();
        Intent expectedIntent = new Intent(activity, CurrenciesListActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
