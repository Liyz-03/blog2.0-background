package com.hiworlds.bbblog.mapper;

import com.hiworlds.bbblog.domain.Dbtest;
import com.hiworlds.bbblog.domain.Post;
import com.hiworlds.bbblog.domain.User;

import java.util.List;


public interface Dbtest01 {

    List<Dbtest> findAll();
    List<Post> findAllPost();
    List<User> findAllUsers();
}
