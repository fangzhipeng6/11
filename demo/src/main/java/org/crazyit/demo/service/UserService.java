package org.crazyit.demo.service;

import java.util.List;

import org.crazyit.demo.dao.UserDao;
import org.crazyit.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public User findById(Integer userId) {
        return userDao.findById(userId).get();
    }
    
    public void save(User user) {
        userDao.save(user);
    }

    
    public Page<User> findAll(Pageable pageable) {
        Example<User> example = getNotDeleteExample();
        return userDao.findAll(example, pageable);
    }
    
    /**
     * 返回一个设置了 isDelete 为 false 的Example
     * @return
     */
    private Example<User> getNotDeleteExample() {
        // 只查询没有删除的图书
        User user = new User();
        user.setIsDelete(false);
        return Example.of(user);
    }
    
    public void delete(Integer[] ids) {
        for(Integer id : ids) {
            User user = findById(id);
            user.setIsDelete(true);
            save(user);
        }
    }
    
    public Page<User> testFindAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }
    
    /**
     * 查找首页书本数据
     */
}
