package com.luliu.rest.service.impl;

import com.luliu.rest.dao.UserDao;
import com.luliu.rest.model.User;
import com.luliu.rest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luliu3 on 2016/7/30.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public List getAll() {
        return userDao.getAll();
    }

    public User getById(Long id) {
        return userDao.get(id);
    }

    public int deleteById(Long id) {

        return userDao.delete(id);
    }

    public int add(User user) {
        return userDao.create(user);
    }

    public int update(User user) {
       return userDao.update(user);
    }
}
