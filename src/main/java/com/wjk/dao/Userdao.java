package com.wjk.dao;

import com.wjk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Userdao extends JpaRepository <User,Integer>{

    public List<User> findAllBySf(Integer i);
}
