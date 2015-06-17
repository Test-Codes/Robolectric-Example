package io.realm.robolectric.example.presenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.realm.robolectric.example.BuildConfig;

import static org.junit.Assert.assertNull;

/**
 * Created by TheFinestArtist on 6/17/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml")
public class MainPresenterTest {

    @Test
    public void notNull() {
        assertNull(null);
    }
}
