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

public class Activity4Test {
    @Rule
    public ActivityTestRule<Activity4> activityTestRule = new ActivityTestRule<Activity4>(Activity4.class);

    private Activity4 act4 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LastActivity.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        act4 = activityTestRule.getActivity();

    }

    @After
    public void tearDown() throws Exception {
        act4=null;
    }

    @Test
    public void onCreate() {
        TextView act4View = act4.findViewById(R.id.act4MsgView);
        Assert.assertNotNull(act4View);
        Assert.assertEquals(act4View,act4.findViewById(R.id.act4MsgView));
    }

    @Test
    public void ButtonClickTest(){
        Assert.assertNotNull(act4.findViewById(R.id.act4button));
        onView(withId(R.id.act4button)).perform(click());
        Activity act5 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(act5);
        Assert.assertEquals("LastActivity",act5.getLocalClassName());
        act5.finish();
    }
}