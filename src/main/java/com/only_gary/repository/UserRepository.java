package com.only_gary.repository;

import com.only_gary.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(int id);
    User findByUsername(String username);

}
