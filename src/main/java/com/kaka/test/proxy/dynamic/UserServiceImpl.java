package com.kaka.test.proxy.dynamic;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by sundaoping on 2018/2/10.
 */
public class UserServiceImpl implements UserService {
    
    @Override
    public String getName(String name) {
        System.out.println(UserServiceImpl.class + " getName invoked ,name:" + name);
        return name;
    }

    @Override
    public Integer getAge(int age) {
        System.out.println(UserServiceImpl.class + " getAge invoked ,age:"+ age);
        return age;
    }
}
