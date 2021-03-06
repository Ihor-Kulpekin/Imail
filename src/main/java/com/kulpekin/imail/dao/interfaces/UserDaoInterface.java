package com.kulpekin.imail.dao.interfaces;

import com.kulpekin.imail.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoInterface extends JpaRepository<User,Integer> {
    User findByEmail(String userEmail);
}
