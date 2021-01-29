package com.olayinkapeter.dummyapi_test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.olayinkapeter.dummyapi_test.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
public class UserAddedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureRecyclerView() {
        onView(withId(R.id.recycler_view))
                .check(matches(isDisplayed()));
    }

}

