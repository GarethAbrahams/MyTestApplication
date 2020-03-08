package com.garethabrahams.mytestapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class Activity2Test {

    @Rule
    public ActivityTestRule<Activity2> activityTestRule = new ActivityTestRule<Activity2>(Activity2.class);
    private Activity2 act2 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity3.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        act2 = activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        act2 = null;
    }

    @Test
    public void onCreate() {
        View act2View = act2.findViewById(R.id.Act2MsgView);
        Assert.assertNotNull(act2View);
        Assert.assertEquals(act2View,act2.findViewById(R.id.Act2MsgView));
    }

    @Test
    public void ButtonClickTest(){
        Assert.assertNotNull(act2.findViewById(R.id.Act2button));
        onView(withId(R.id.Act2button)).perform(click());
        Activity act3 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(act3);
        Assert.assertEquals("Activity3",act3.getLocalClassName());
        act3.finish();
    }
}