package com.luliu.rest.dao.impl;

import com.luliu.rest.dao.UserDao;
import com.luliu.rest.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author luliu3 on 2016/7/30.
 */

/*
The best way to guarantee that your Data Access Objects (DAOs)
or repositories provide exception translation is to use the
@Repository annotation.

This annotation also allows the component scanning support
to find and configure your DAOs and repositories without having to provide
XML configuration entries for them.
*/
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {

        List<User> list = null;
        try {
            String sql = "SELECT * FROM user";
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User get(Long id) {
        User user = null;
        try {
            String sql = "SELECT * FROM user WHERE id=?";
            Object[] paras = new Object[] { id };
            user = jdbcTemplate.queryForObject(sql, paras, new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int create(User user) {

        String sql = "INSERT INTO user " +"(id, firstname, lastname, email, mobile) VALUES (?, ?, ?, ?, ?)";
        Object[] paras = new Object[] { user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile() };
        return jdbcTemplate.update(sql, paras);
    }

    public int delete(Long id) {

        String sql = "DELETE FROM user WHERE id=?";
        Object[] paras = new Object[] { id };
        return jdbcTemplate.update(sql, paras);
    }

    public int update(User user) {

        String sql = "UPDATE user SET firstname = ?,lastname = ?, email = ?, mobile = ? WHERE id = ?";
        Object[] paras = new Object[] {user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile(), user.getId()};
        return jdbcTemplate.update(sql, paras);
    }
}
