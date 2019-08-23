package com.twinkle.service;

import com.twinkle.dao.UserDao;
import com.twinkle.pojo.User;
import com.twinkle.util.DateUtil;
import com.twinkle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     *  用户注册
     * @param user
     */
    public void save(User user){
        user.setUserId(idWorker.nextId()+"");
        user.setUserCreateTime(dateUtil.returnDate());
        user.setUserRoles("user");
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        userDao.save(user);
    }


    /***
     * 管理员登录
     */
    public User login(User user) {
        User newUser = userDao.findByUserName(user.getUserName());
        if(newUser != null && bCryptPasswordEncoder.matches(user.getUserPassword(),newUser.getUserPassword())){
            return newUser;
        }
        return null;
    }
}
