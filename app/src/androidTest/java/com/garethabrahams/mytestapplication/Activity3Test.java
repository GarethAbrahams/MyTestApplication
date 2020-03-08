package com.garethabrahams.mytestapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.widget.TextView;

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

public class Activity3Test {
    @Rule
    public ActivityTestRule<Activity3> activityTestRule = new ActivityTestRule<Activity3>(Activity3.class);

    private Activity3 act3 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity4.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        act3 = activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        act3 = null;
    }

    @Test
    public void onCreate() {
        TextView act3View = act3.findViewById(R.id.Act3MsgView);
        Assert.assertNotNull(act3View);
        Assert.assertEquals(act3View,act3.findViewById(R.id.Act3MsgView));
    }

    @Test
    public void ButtonClickTest(){
        Assert.assertNotNull(act3.findViewById(R.id.Act3button));
        onView(withId(R.id.Act3button)).perform(click());
        Activity act4 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(act4);
        Assert.assertEquals("Activity4",act4.getLocalClassName());
        act4.finish();
    }
}