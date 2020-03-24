package com.ruanjian.my.shop.web.api.web.controller.v1;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.domain.TbUser;
import com.ruanjian.my.shop.web.api.service.TbUserService;
import com.ruanjian.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 会员管理
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    //登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        TbUser user = tbUserService.login(tbUser);
        if(user==null){
            return BaseResult.fail("账号或密码错误");
        }

        else{
            TbUserDTO dto=new TbUserDTO();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("成功",dto);
        }

    }
    //注册
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(TbUser tbUser, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult=tbUserService.register(tbUser);
        //注册成功
        if(baseResult.getStatus()==200){
            TbUserDTO dto=new TbUserDTO();
            BeanUtils.copyProperties(baseResult.getData(),dto);
            return BaseResult.success("注册成功",dto);

        }
        //注册失败
        else {
            return baseResult;
        }
    }

}
