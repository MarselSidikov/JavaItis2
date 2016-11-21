package ru.itis.factories;

import ru.itis.dao.UsersDao;
import ru.itis.service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.Properties;

public class ServiceFactory {
    // поле, которое хранит единственный экземпляр
    private static ServiceFactory instance;

    private UserService userService;

    private Properties properties;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        properties = new Properties();
        try {
            properties.load(new
                    FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis2\\" +
                    "EnterpriseTemplate\\src\\main\\" +
                    "resources\\application.properties"));

            String serviceClassName = properties.getProperty("users.service.class");

            Constructor constructor = Class.forName(serviceClassName).getConstructor(UsersDao.class);
            userService = (UserService)constructor.newInstance(DaoFactory.getInstance().getUsersDao());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
