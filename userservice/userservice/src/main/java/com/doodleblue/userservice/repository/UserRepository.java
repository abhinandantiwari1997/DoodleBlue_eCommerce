package com.doodleblue.userservice.repository;

import com.doodleblue.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("select u.userId from User u where u.email=?1")
    public Long getIdByEmail(String email);
    @Query("select u.userId from User u where u.email=?1")
    public User getUserByEmail(String email);


}