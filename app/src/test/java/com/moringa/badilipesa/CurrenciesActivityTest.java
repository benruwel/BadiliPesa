package com.moringa.badilipesa;
import android.content.Intent;

import com.moringa.badilipesa.ui.ConverterActivity;
import com.moringa.badilipesa.ui.CurrenciesActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class CurrenciesActivityTest {
    private CurrenciesActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(CurrenciesActivity.class);
    }

    @Test
    public void converterActivityStarted() {
        activity.findViewById(R.id.convertViewButton).performClick();
        Intent expectedIntent = new Intent(activity, ConverterActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
