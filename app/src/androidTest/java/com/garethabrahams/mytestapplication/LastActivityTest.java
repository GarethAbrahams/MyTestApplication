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

public class LastActivityTest {
    @Rule
    public ActivityTestRule<LastActivity> activityTestRule = new ActivityTestRule<LastActivity>(LastActivity.class);

    private LastActivity act5 = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        act5 = activityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        act5 = null;
    }

    @Test
    public void onCreate() {
        TextView act5View = act5.findViewById(R.id.act5MsgView);
        Assert.assertNotNull(act5View);
        Assert.assertEquals(act5View,act5.findViewById(R.id.act5MsgView));
    }

    @Test
    public void ButtonClickTest(){
        Assert.assertNotNull(act5.findViewById(R.id.act5button));
        onView(withId(R.id.act5button)).perform(click());
        Activity actMain = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(actMain);
        Assert.assertEquals("MainActivity",actMain.getLocalClassName());
        actMain.finish();
    }

}