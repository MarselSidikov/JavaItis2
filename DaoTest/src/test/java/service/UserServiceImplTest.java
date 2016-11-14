package service;

import dao.UsersDao;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static dao.UsersDaoArrayListImplTest.TEST_DATA;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by admin on 14.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UsersDao usersDao;

    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        // создали мок-объект, объект с временной реализацией
        // usersDao = mock(UsersDao.class);
        userService = new UserServiceImpl(usersDao);

        User user = new User("Vasya", "javaProgrammist", "qwerty007");
        User defaultUser = new User("DEFAULT", "DEFAULT", "DEFAULT");
        when(usersDao.findAll()).thenReturn(TEST_DATA);
        when(usersDao.find(anyInt())).thenReturn(defaultUser);
        when(usersDao.find(2)).thenReturn(user);
    }

    @Test
    public void isRegistered() throws Exception {
        boolean actual = userService.isRegistered("Marsel");
        assertTrue(actual);
    }

    @Test
    public void getUser() throws Exception {
        String actualName = userService.getUser(2).getName();
        String expectedName = "Vasya";

        assertEquals(actualName, expectedName);
    }
}