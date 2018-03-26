package com.only_gary.Dao;

import com.only_gary.model.User;

public interface UserDao {

    User addNewUser (User user);
    User addNewUser ( String name, String email);
    User getUserById( int id);
    User getUserByUsername( String username);
    Iterable<User> getAllUsers();
}
