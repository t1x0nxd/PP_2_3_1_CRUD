package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User updatedUser) {
        userDAO.updateUser(updatedUser);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }
}
