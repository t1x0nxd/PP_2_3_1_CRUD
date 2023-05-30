package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser (User user);

    void deleteUser (long id);

    void updateUser (User updatedUser);

    List<User> getAllUsers ();

    User getUser (long id);
}
