package com.ruanjian.my.shop.web.admin.service;

import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.commons.dto.PageInfo;
import com.ruanjian.my.shop.commons.persistence.BaseService;
import com.ruanjian.my.shop.domain.TbContent;
import com.ruanjian.my.shop.domain.TbUser;

import java.util.List;
import java.util.Map;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
