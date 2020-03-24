package com.ruanjian.my.shop.web.admin.service.test;

import com.ruanjian.my.shop.domain.TbUser;
import com.ruanjian.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for(TbUser tbUser:tbUsers){
            System.out.println(tbUser.getUsername());
        }

    }
    @Test
    public void testInsert(){
       TbUser tbUser=new TbUser();
       tbUser.setUsername("ruanjian1");
       tbUser.setPhone("888889");
       tbUser.setEmail("ruanjian@sina1.com");
       tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
       tbUser.setCreated(new Date());
       tbUser.setUpdated(new Date());

       tbUserService.save(tbUser);
    }

    @Test
    public void testDelete(){
        tbUserService.delete(42L);
    }

    @Test
    public void  testGetById(){
       TbUser tbUser=tbUserService.getById(38L);
        System.out.println(tbUser);
    }

    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.getById(38L);
        tbUser.setUsername("ruanjian888888888");
        tbUserService.update(tbUser);
    }

}
