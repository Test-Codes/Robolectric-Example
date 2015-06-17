package io.realm.robolectric.example;

import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        assertEquals(userInfoTextView.getText().toString(), "FullName : Leonardo\nEmail : null");
    }

    @Test
    public void emailShouldUpdateUserInfoTextView() {
        email.setText("contact@thefinestartist.com");
        assertEquals(userInfoTextView.getText().toString(), "FullName : null\nEmail : contact@thefinestartist.com");
    }

    @Test
    public void fullNameAndEmailShouldUpdateUserInfoTextView() {
        fullName.setText("Leonardo");
        email.setText("contact@thefinestartist.com");
        assertEquals(userInfoTextView.getText().toString(), "FullName : Leonardo\nEmail : contact@thefinestartist.com");
    }
}
