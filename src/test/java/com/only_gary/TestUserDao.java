package com.only_gary;

import com.only_gary.DaoImpl.UserDaoImpl;
import com.only_gary.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserDao {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Test
    @Transactional
    public void addNewUser() {

        User user = new User();
        user.setName("Test Name");
        user.setEmail("testEmail@email.com");
        user.setUsername("testUserName");
        userDaoImpl.addNewUser(user);

        List<User> users = userDaoImpl.getAllUsers();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user, userDaoImpl.getUserById(1));
    }

}