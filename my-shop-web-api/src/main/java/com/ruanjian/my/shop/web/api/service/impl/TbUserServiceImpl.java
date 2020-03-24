package com.ruanjian.my.shop.web.api.service.impl;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.commons.validator.BeanValidator;
import com.ruanjian.my.shop.domain.TbUser;
import com.ruanjian.my.shop.web.api.dao.TbUserDao;
import com.ruanjian.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if(user!=null){
            //将明文密码加密
            String password= DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if(password.equals(user.getPassword())){
                return user;
            }
        }

        return null;
    }

    @Override
    public BaseResult register(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if(validator!=null){
            return BaseResult.fail(validator);
        }
        int count = tbUserDao.count(tbUser);
        if(count>0){
            return BaseResult.fail("用户名或者电话号码重复");
        }

        //通过验证
        else{
            tbUser.setUpdated(new Date());
            //注册用户
            if(tbUser.getId()==null){
                //密码需要加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.register(tbUser);
            }

            return BaseResult.success("注册成功",tbUser);
        }
    }

}
