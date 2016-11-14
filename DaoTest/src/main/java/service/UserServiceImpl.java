package service;

import dao.UsersDao;
import model.User;

import java.util.List;

// слой сервисов приложения - это слой с бизнес-логикой
// определенные алгоритмы в системе
public class UserServiceImpl implements UserService {

    private UsersDao usersDao;

    public UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if (currentUser.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void addUser(User user) {
        usersDao.save(user);
    }

    public User getUser(int id) {
        return usersDao.find(id);
    }
}
