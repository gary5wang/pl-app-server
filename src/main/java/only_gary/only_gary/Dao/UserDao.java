package only_gary.Dao;

import only_gary.model.User;

public interface UserDao {

    User addNewUser ( String name, String email);
    User getUserById( int id);
    User getUserByUsername( String username);
    Iterable<User> getAllUsers();
}
