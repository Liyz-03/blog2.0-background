package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.User;

/**
 *  @author: Liyz
 *  @Date: 2020/7/22 13:59
 *  @Description:userDAo
 **/

public interface UserDao {

    User findOneUserByEmailAndPassword(String email,String password);

    User findOneUserByEmail(String email);

    int saveUser(User user);
}
