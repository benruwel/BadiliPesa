package com.moringa.badilipesa;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class ConverterActivityTest {
    private ConverterActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(ConverterActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView introText = activity.findViewById(R.id.textView);
        assertTrue("US Dollar".equals(introText.getText().toString()));
    }

    @Test
    public void validateTextView5Content() {
        TextView introText = activity.findViewById(R.id.textView5);
        assertTrue("Results:".equals(introText.getText().toString()));
    }
}
