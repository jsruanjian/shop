package com.ruanjian.my.shop.web.api.dao;

import com.ruanjian.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 */
@Repository
public interface TbUserDao {
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
    void register(TbUser tbUser);

    /**
     * 检查是否重复
     * @param tbUser
     * @return
     */
    int count(TbUser tbUser);
}
