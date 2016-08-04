package com.luliu.rest.dao;

import com.luliu.rest.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author luliu3 on 2016/8/3.
 */
public interface UserMapper {

    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where id=#{id}")
    public User get(Long id);

    @Insert("insert into user(id, firstname, lastname, email, mobile)" +
            "values(#{id}, #{firstname}, #{lastname}, #{email}, #{mobile})")
    public int create(User user);

    @Delete("delete from user where id=#{id}")
    public int delete(Long id);

    @Update("update user set name=#{name}, password=#{password} where id=#{id}")
    public int update(User user);
}
