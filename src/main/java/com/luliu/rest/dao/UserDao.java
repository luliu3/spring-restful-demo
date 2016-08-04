package com.luliu.rest.dao;

import com.luliu.rest.model.User;

import java.util.List;

/**
 * @author luliu3 on 2016/7/30.
 */
public interface UserDao {
    public List<User> getAll();
    public User get(Long id);
    public int create(User user);
    public int delete(Long id);
    public int update(User user);
}
