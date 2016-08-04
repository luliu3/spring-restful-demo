package com.luliu.rest.service.mybatis;

import com.luliu.rest.dao.IUserDao;
import com.luliu.rest.model.User;
import com.luliu.rest.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luliu3 on 2016/8/4.
 */

@Service("MybatisUserService")
public class UserService implements IUserService {

    @Resource(name = "MybatisUserDao")
    private IUserDao userDao;

    public int add(User user) {
        return userDao.create(user);
    }

    public List getAll() {
        return userDao.getAll();
    }

    public User getById(Long id) {
        return userDao.get(id);
    }

    public int deleteById(Long id) {
        return userDao.delete(id);
    }

    public int update(User user) {
        return userDao.update(user);
    }
}
