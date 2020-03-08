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

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Rule
    //public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    private MainActivity mainActivity =null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(Activity2.class.getName(),null,false);



    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();

    }

    @Test
    public void onCreate() {
        View mainView = mainActivity.findViewById(R.id.mainTextView);
        Assert.assertNotNull(mainView);
        Assert.assertEquals(mainView,mainActivity.findViewById(R.id.mainTextView));

    }

    @Test
    public void ButtonClickTest(){
        Assert.assertNotNull(mainActivity.findViewById(R.id.button));
        onView(withId(R.id.button)).perform(click());
        Activity act2 = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        Assert.assertNotNull(act2);
        Assert.assertEquals("Activity2",act2.getLocalClassName());
        act2.finish();
    }

    @Test
    public void ActivityIntentTest(){
       // Intent mainIntent = new Intent();
       // String text = "Testing";
       // mainIntent.putExtra("Test",text);
       // Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK,mainIntent);



    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}