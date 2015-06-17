package io.realm.robolectric.example;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by TheFinestArtist on 6/16/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml")
public class MainActivityTest {

    private MainActivity activity;
    private TextView userInfoTextView;
    private EditText fullName;
    private EditText email;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        userInfoTextView = (TextView) activity.findViewById(R.id.userInfo);
        fullName = (EditText) activity.findViewById(R.id.fullName);
        email = (EditText) activity.findViewById(R.id.email);
    }

    @Test
    public void notNull() {
        assertNotNull(activity);
    }

    @Test
    public void fullNameShouldUpdateUserInfoTextView() {
        fullName.setText("Leonardo");
        assertTrue(userInfoTextView.getText().toString().contains("Leonardo"));
    }

    @Test
    public void emailShouldUpdateUserInfoTextView() {
        email.setText("contact@thefinestartist.com");
        assertTrue(userInfoTextView.getText().toString().contains("contact@thefinestartist.com"));
    }

    @Test
    public void fullNameAndEmailShouldUpdateUserInfoTextView() {
        fullName.setText("Leonardo");
        email.setText("contact@thefinestartist.com");
        assertTrue(userInfoTextView.getText().toString().contains("Leonardo"));
        assertTrue(userInfoTextView.getText().toString().contains("contact@thefinestartist.com"));
    }
}
