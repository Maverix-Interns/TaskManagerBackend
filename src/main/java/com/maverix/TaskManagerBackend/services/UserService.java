package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    User createUser(User user);

    User updateUser(long id, User updatedUser);

    void deleteUser(long id);
}
