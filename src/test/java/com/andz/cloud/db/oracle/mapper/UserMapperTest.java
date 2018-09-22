package com.andz.cloud.db.oracle.mapper;

import com.andz.cloud.db.oracle.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: antz-cloud-dbmybatis
 * @description:
 * @author: huanghuang@rewin.com.cn
 * @Create: 2018-09-22 12:08
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper ;

    @Test
    public void saveTest(){
        User user = new User();
        user.setName("123");
        user.setSex(1);
        userMapper.insert(user);
    }
}
