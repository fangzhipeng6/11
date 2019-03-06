package org.crazyit.demo.dao;

import java.util.List;

import org.crazyit.demo.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    // 查询前3条 isDelete 的数据，并且会根据 id 排序
    List<User> findTop3ByIsDeleteOrderByIdDesc(boolean isDelete);
}