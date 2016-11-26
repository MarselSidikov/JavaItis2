package ru.itis.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import javax.jws.soap.SOAPBinding;
import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String MAN_NAME = "Marsel";
    private static final String WOMAN_NAME = "Nastya";
    private static final String INCORRECT_NAME = "Cheburek";
    private static final User MARSEL = new User("Marsel", 'm');
    private static final User NASTYA = new User("Nastya", 'w');
    private static final User NEW_USER = new User("Leha", 'm');

    private static final List<User> USER_LIST = Arrays.asList(MARSEL, NASTYA);

    private UserServiceImpl testedService;

    @Mock
    private UsersDao usersDao;

    @Mock
    private UserUtils userUtils;

    @Before
    public void setUp() throws Exception {
        // stubbing - метод просто возращает значение
        when(usersDao.findAll()).thenReturn(USER_LIST);
        // КОГДА МЕТОД ВОЗРАЩАЕТ ЗНАЧЕНИЕ И МОЖЕТ ГЕНЕРИРОВАТЬ ИСКЛЮЧЕНИЕ
        // СТАББИНГ ДЕЛАЕТСЯ ВОТ ТАК:
        doThrow(new IllegalArgumentException()).when(usersDao).find(anyInt());
        doReturn(MARSEL).when(usersDao).find(1);

        // МЕТОД-процедура, не возвращает значения, но может генерировать исключение
        doNothing().when(userUtils).checkAlreadyRegistered(anyString(), anyList());
        doThrow(new IllegalArgumentException()).when(userUtils).checkAlreadyRegistered("Marsel", USER_LIST);
        testedService = new UserServiceImpl(usersDao, userUtils);
    }

    @Test
    public void testIsManOnManName() throws Exception {
        Assert.assertTrue(testedService.isMan(MAN_NAME));
    }

    @Test
    public void testIsManOnWomanName() throws Exception {
        assertFalse(testedService.isMan(WOMAN_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsManOnIncorrectName() throws Exception {
        testedService.isMan(INCORRECT_NAME);
    }

    @Test
    public void testAddUser() throws Exception {
        testedService.addUser(MARSEL);
        verify(usersDao).saveUser(MARSEL);
    }

    @Test
    public void testFindUser() throws Exception {
        User actual = testedService.findUserById(1);
        assertEquals("Marsel", actual.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindUserOnIncorrect() throws Exception {
        testedService.findUserById(2);
    }

    @Test
    public void testRegisterUser() throws Exception {
        testedService.registerUser(NEW_USER);
        verify(userUtils).checkAlreadyRegistered(NEW_USER.getName(), USER_LIST);
        verify(usersDao).saveUser(NEW_USER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterUserOnAlreadyRegistered() throws Exception {
        testedService.registerUser(MARSEL);
    }

}