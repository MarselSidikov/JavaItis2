package ru.itis.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoArrayListImpl;
import ru.itis.models.User;

import static org.junit.Assert.*;

public class UserServiceImplTestWithDaoIntegration {

    private UserServiceImpl testedService;

    private static final String MAN_NAME = "Marsel";
    private static final String WOMAN_NAME = "Nastya";
    private static final String INCORRECT_NAME = "Cheburek";
    private static final User MARSEL = new User("Marsel", 'm');
    private static final User NASTYA = new User("Nastya", 'w');

    private UsersDao usersDao;

    @Before
    public void setUp() throws Exception {
        usersDao = new UsersDaoArrayListImpl();

        usersDao.saveUser(MARSEL);
        usersDao.saveUser(NASTYA);

        // НИКОГДА НЕ переДАВАЙТЕ НУЛЛ!!
        testedService = new UserServiceImpl(usersDao, null);
    }

    @Test
    public void testIsManOnManName() throws Exception {
        /*
        boolean expected = true;
        boolean actual = testedService.isMan("Marsel");

        assertEquals(expected, actual);
        */

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
}