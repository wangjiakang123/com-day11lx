package com.wjk.dao;

import com.wjk.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {

   public List<Order> findByReqi(Date date);

   public List<Order> findAllByUserid(Integer id);

}
