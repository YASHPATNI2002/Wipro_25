package com.wipro.usermgmtv.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.usermgmtv.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmailAndPassWord(String email, String passWord);
}
