package com.nmironov.internetshop.repository.admin;

import com.nmironov.internetshop.model.User;

import java.util.List;

public interface UserRepository {
    User getUserById(Long id);

    User getUserByUsername(String username);

    User getAdminById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long userId);

    void updateUser(User user);
}
