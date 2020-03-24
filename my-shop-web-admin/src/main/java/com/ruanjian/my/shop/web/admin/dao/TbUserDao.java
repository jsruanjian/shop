package com.ruanjian.my.shop.web.admin.dao;

import com.ruanjian.my.shop.commons.persistence.BaseDao;
import com.ruanjian.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao extends BaseDao<TbUser>{

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
