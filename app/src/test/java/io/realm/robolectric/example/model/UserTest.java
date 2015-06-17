package io.realm.robolectric.example.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.realm.robolectric.example.BuildConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by TheFinestArtist on 6/17/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml")
public class UserTest {

    private User user;

    @Before
    public void setup() {
        user = new User();
    }

    @Test
    public void notNull() {
        assertNotNull(user);
    }

    @Test
    public void fullNameShouldUpdate() {
        user.setFullName("Leonardo");
        assertEquals(user.getFullName(), "Leonardo");
    }

    @Test
    public void emailShouldUpdate() {
        user.setEmail("contact@thefinestartist.com");
        assertEquals(user.getEmail(), "contact@thefinestartist.com");
    }

    @Test
    public void fullNameShouldUpdateToString() {
        user.setFullName("Leonardo");
        assertEquals(user.toString(), "FullName : Leonardo\nEmail : null");
    }

    @Test
    public void emailShouldUpdateToString() {
        user.setEmail("contact@thefinestartist.com");
        assertEquals(user.toString(), "FullName : null\nEmail : contact@thefinestartist.com");
    }

    @Test
    public void fullNameAndEmailShouldUpdateToString() {
        user.setFullName("Leonardo");
        user.setEmail("contact@thefinestartist.com");
        assertEquals(user.toString(), "FullName : Leonardo\nEmail : contact@thefinestartist.com");
    }
}
