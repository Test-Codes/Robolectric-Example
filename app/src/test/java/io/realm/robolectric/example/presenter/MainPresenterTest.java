package io.realm.robolectric.example.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;

import io.realm.robolectric.example.BuildConfig;
import io.realm.robolectric.example.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by TheFinestArtist on 6/17/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml")
public class MainPresenterTest {

    @Mock
    private MainPresenter.View view;
    private MainPresenter presenter;
    private User user;

    @Before
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(view);

        Field field = MainPresenter.class.getDeclaredField("user");
        field.setAccessible(true);

        user = (User) field.get(presenter);
    }

    @Test
    public void notNull() {
        assertNotNull(presenter);
        assertNotNull(view);
        assertNotNull(user);
    }

    @Test
    public void updateFullNameTest() {
        presenter.updateFullName("Leonardo");
        assertEquals(user.getFullName(), "Leonardo");
        verify(view).updateUserInfoTextView(user.toString());
    }

    @Test
    public void updateEmailTest() {
        presenter.updateEmail("contact@thefinestartist.com");
        assertEquals(user.getEmail(), "contact@thefinestartist.com");
        verify(view).updateUserInfoTextView(user.toString());
    }

}
