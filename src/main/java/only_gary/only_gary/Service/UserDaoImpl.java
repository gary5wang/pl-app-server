package only_gary.Service;

import only_gary.Dao.UserDao;
import only_gary.model.User;
import only_gary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addNewUser(String name, String email) {

            User user = new User();
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            return user;
        }

        public User getUserById(int id) {

            User n = userRepository.findById(id);
            if (n != null) {
                return n;
            }
            return null;
        }

        public User getUserByUsername(String username) {

            User n = userRepository.findByUsername(username);
            if (n != null) {
                return n;
            }
            return null;
        }

        public Iterable<User> getAllUsers() {

            return userRepository.findAll();
        }
}