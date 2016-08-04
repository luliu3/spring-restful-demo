package com.luliu.rest.dao.mybatis;

import com.luliu.rest.dao.IUserDao;
import com.luliu.rest.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luliu3 on 2016/8/4.
 */
@Repository("MybatisUserDao")
public class UserDao implements IUserDao {

    @Resource
    SqlSession sqlSession;

    public int create(User user) {
        return sqlSession.insert("mapper.User.insertUser", user);
    }

    public List<User> getAll() {
        return sqlSession.selectList("mapper.User.getUserList");
    }

    public User get(Long id) {
        return sqlSession.selectOne("mapper.User.getUser", id);
    }

    public int delete(Long id) {
        return sqlSession.delete("mapper.User.deleteUser", id);
    }

    public int update(User user) {
        return sqlSession.update("mapper.User.updateUser", user);
    }
}
