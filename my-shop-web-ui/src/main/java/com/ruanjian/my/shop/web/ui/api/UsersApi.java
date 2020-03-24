package com.ruanjian.my.shop.web.ui.api;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.commons.utils.HttpClientUtils;
import com.ruanjian.my.shop.commons.utils.MapperUtils;
import com.ruanjian.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员管理接口
 */
public class UsersApi {

    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;

    }

    public static String  register(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params=new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        params.add(new BasicNameValuePair("phone",tbUser.getPhone()));
        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));
        return json;

    }
}
