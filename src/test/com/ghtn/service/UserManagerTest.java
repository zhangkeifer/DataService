package com.ghtn.service;

import com.ghtn.BaseTestCase;
import com.ghtn.model.mysql.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-1
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserManagerTest extends BaseTestCase {

    @Resource
    private UserManager userManager;

    private static Log log = LogFactory.getLog(UserManagerTest.class);

    @Test
    public void testSave() {
        User user = new User();
        user.setName("数据源111");
        user.setAge(20);
    }

    @Test
    public void testGet() {
        System.out.println(userManager.getUserMysqlDataSource1(66L).getName());
        System.out.println(userManager.getUserMysqlDataSource2(29L).getName());
    }

    @Test
    public void testSave2() {
        User user = new User();
        user.setName("user1");
        userManager.saveUserMysqlDataSource1(user);

        user.setName("user2");
        userManager.saveUserMysqlDataSource2(user);

    }

}
