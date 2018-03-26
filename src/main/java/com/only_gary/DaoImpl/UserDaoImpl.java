package com.only_gary.DaoImpl;

import com.only_gary.Dao.UserDao;
import com.only_gary.model.User;
import com.only_gary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addNewUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User addNewUser(String name, String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(int id) {

        User n = userRepository.findById(id);
        if (n != null) {
            return n;
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {

        User n = userRepository.findByUsername(username);
        if (n != null) {
            return n;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return (List)userRepository.findAll();
    }
}