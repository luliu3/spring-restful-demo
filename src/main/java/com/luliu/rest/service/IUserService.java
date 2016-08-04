package com.luliu.rest.service;

import com.luliu.rest.model.User;

import java.util.List;

/**
 * @author luliu3 on 2016/7/30.
 */
public interface IUserService {

    public List getAll();

    public User getById(Long id);

    public int deleteById(Long id);

    public int add(User user);

    public int update(User user);

}
