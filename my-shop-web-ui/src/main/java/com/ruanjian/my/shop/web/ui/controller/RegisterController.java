package com.ruanjian.my.shop.web.ui.controller;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.commons.utils.MapperUtils;
import com.ruanjian.my.shop.web.ui.api.UsersApi;
import com.ruanjian.my.shop.web.ui.constant.SystemConstants;
import com.ruanjian.my.shop.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 注册控制器
 * <p>Title: RegisterController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/7/5 12:34
 */
@Controller
public class RegisterController {
    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 注册
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        String message="";
        String json = UsersApi.register(tbUser);
        Map<String, Object> json2map = MapperUtils.json2map(json);
        if(json2map!=null){
             message= (String) json2map.get("message");
        }
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);

        //注册失败
        if (user==null){
            model.addAttribute("baseResult",BaseResult.fail(message));
            return "register";
        }

        //注册成功
        else{
            //将会员信息放入Session
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY,user);
            //重定向回首页
            return "redirect:/index";
        }

    }

}
