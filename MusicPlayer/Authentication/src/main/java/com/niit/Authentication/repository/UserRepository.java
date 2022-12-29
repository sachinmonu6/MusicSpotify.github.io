package com.niit.Authentication.repository;

import com.niit.Authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByEmailidAndPassword(String emailid, String password);
    public User findByEmailid(String emailid);

}
