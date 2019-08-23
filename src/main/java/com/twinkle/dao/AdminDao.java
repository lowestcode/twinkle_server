package com.twinkle.dao;

import com.twinkle.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {

    public User findByUserName(String userName);
}
