package com.ruanjian.my.shop.commons.persistence;

import com.ruanjian.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * 通用的树形结构接口(业务逻辑层)
 * @param <T>
 */
public interface BaseTreeService<T extends BaseEntity> {
    /**
     * 查询用全部数据
     * @return
     */
    public List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    public BaseResult save(T  entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */

    T getById(Long id);

    /**
     * 更新
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点ID查询所有子节点
     * @param pid
     * @return
     */
    List<T> selectByPid(Long pid);
}
