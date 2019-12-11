package com.wjk.test;

import com.alibaba.fastjson.JSON;
import com.wjk.dao.OrderDao;
import com.wjk.dao.Userdao;
import com.wjk.model.Order;
import com.wjk.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private Userdao userdao;
    @Autowired
    private OrderDao orderDao;

    @Test
    public void tesr(){
        for (int i=1;i<6;i++){
            User user=new User();
            user.setName("王"+i);
            user.setPassword("123"+i);
            user.setUsername("常涛涛"+i);
            user.setSf(1);
            userdao.saveAndFlush(user);
        }

    }

    @Test
    public void ta(){
        List<User> all = userdao.findAll();
        System.out.println(all);
        for (int i=0;i<2;i++){
            for (int k=0;k<all.size();k++){
                Order order=new Order();
                order.setUserid(all.get(k).getId());
                order.setJine(1+k);
                order.setReqi(new Date());
                order.setSfsc("否");
                orderDao.saveAndFlush(order);
            }
        }
    }
    @Test
    public void getid(){
        Optional<User> byId = userdao.findById(3);
      // System.out.println(JSON.toJSONString(byId.get().getList()));
    }

    @Test
    public void getorderid(){
        Optional<Order> byId = orderDao.findById(3);
        System.out.println(JSON.toJSONString(byId.get()));
    }


    @Test
    public void getrepi(){
        Calendar instance = Calendar.getInstance();
        instance.set(2019,11,11,15,05,18);
        List<Order> ta = orderDao.findByReqi(instance.getTime());
        System.out.println(JSON.toJSONString(ta));
    }

    @Test
    public void del(){
            userdao.deleteById(1);
    }

    @Test
    public void list(){
        List<User> allBySf = userdao.findAllBySf(1);
        System.out.println(allBySf);
    }

    @Test
    public void upt(){
        Optional<User> byId = userdao.findById(11);
        User user = byId.get();
        user.setSf(0);
        List<Order> list = user.getList();
        for (int i=0;i<list.size();i++){
            Order order = list.get(i);
            order.setSfsc("是");
        }
        userdao.saveAndFlush(user);
    }
}
