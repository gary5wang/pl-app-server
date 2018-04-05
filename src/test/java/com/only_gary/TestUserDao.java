package com.only_gary;

import com.only_gary.DaoImpl.TrackableDoubleDaoImpl;
import com.only_gary.DaoImpl.TrackableMetadataDaoImpl;
import com.only_gary.DaoImpl.UserDaoImpl;
import com.only_gary.model.TrackableDouble;
import com.only_gary.model.TrackableMetadata;
import com.only_gary.model.TrackableObject;
import com.only_gary.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserDao {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private TrackableMetadataDaoImpl trackableMetadataDaoImpl;

    @Autowired
    private TrackableDoubleDaoImpl trackableDoubleDaoImpl;


    private User addNewUser() {

        User user = new User();
        user.setName("Test Name");
        user.setEmail("testEmail@email.com");
        user.setUsername("testUserName");
        return userDaoImpl.addNewUser(user);
    }

    private TrackableMetadata addNewTrackableMetadata() {

        User user = addNewUser();
        return trackableMetadataDaoImpl.addTrackableMetadata(user.getId(), "Test Table");
    }

    private TrackableDouble addNewTrackableDouble() {

        TrackableMetadata trackableMetadata = addNewTrackableMetadata();
        return trackableDoubleDaoImpl.addTrackableDouble(trackableMetadata, new Timestamp(1522819325), 185.0);
    }

    @Test
    @Transactional
    public void verifyAddNewUser() {

        User user = addNewUser();
        List<User> users = userDaoImpl.getAllUsers();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user, userDaoImpl.getUserById(1));
    }

    @Test
    @Transactional
    public void verifyAddNewTrackableMetadata() {
        TrackableMetadata trackableMetadata = addNewTrackableMetadata();

        Assert.assertEquals(1, trackableMetadata.getUserId());
    }

    @Test
    @Transactional
    public void verifyAddNewTrackableDouble() {
        TrackableDouble trackableDouble = addNewTrackableDouble();

        List<TrackableObject> trackableObjectList = trackableMetadataDaoImpl.getTrackableObjectList(trackableDouble.getTrackableMetadata().getId());
        Assert.assertEquals( trackableDouble, trackableObjectList.get(0));
    }
}