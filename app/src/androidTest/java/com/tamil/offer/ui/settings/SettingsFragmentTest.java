package com.tamil.offer.ui.settings;

import androidx.annotation.ContentView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.tamil.offer.R;
import com.tamil.offer.ui.home.MainActivity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class SettingsFragmentTest {
    @Rule
    public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void check_input_fields_are_not_empty() {
        ViewInteraction menuClick = Espresso.onView(ViewMatchers.withId(R.id.action_settings));
        menuClick.perform(click());

        ViewInteraction appId = Espresso.onView(ViewMatchers.withId(R.id.app_id_edit_text));
        ViewInteraction userId = Espresso.onView(ViewMatchers.withId(R.id.user_id_edit_text));
        ViewInteraction token = Espresso.onView(ViewMatchers.withId(R.id.token_edit_text));

        appId.check(matches(isDisplayed()));
        userId.check(matches(isDisplayed()));
        token.check(matches(isDisplayed()));

        appId.check(matches(not(withText(""))));
        userId.check(matches(not(withText(""))));
        token.check(matches(not(withText(""))));
    }
}