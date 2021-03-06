package com.ghtn.service.impl;

import com.ghtn.dao.UserDao;
import com.ghtn.model.mysql.User;
import com.ghtn.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-1
 * Time: 上午10:12
 * To change this template use File | Settings | File Templates.
 */
@Service("userManager")
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {

    private UserDao userDao;

    @Autowired
    public UserManagerImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public User saveUserMysqlDataSource1(User user) {
        return userDao.save(user);
    }

    @Override
    public User saveUserMysqlDataSource2(User user) {
        return userDao.save(user);
    }

    @Override
    public User saveUserOracleDataSource3(User user) {
        return userDao.save(user);
    }

    @Override
    public User saveUserOracleDataSource4(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUserMysqlDataSource1(Long id) {
        return userDao.get(id);
    }

    @Override
    public User getUserMysqlDataSource2(Long id) {
        return userDao.get(id);
    }

    @Override
    public List<User> listUserMysqlDataSource1() {
        return userDao.listUser();
    }
}
