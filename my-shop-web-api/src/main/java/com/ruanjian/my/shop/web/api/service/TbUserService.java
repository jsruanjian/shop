package com.ruanjian.my.shop.web.api.service;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.domain.TbUser;

/**
 * 会员管理
 */
public interface TbUserService {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);

    /**
     * 注册
     * @param tbUser
     * @return
     */
    BaseResult register(TbUser tbUser);


}
