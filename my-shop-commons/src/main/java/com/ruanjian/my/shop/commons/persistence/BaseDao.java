package com.ruanjian.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的基类
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询用全部数据
     * @return
     */
    public List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    public void insert(T  entity);

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
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params  需要两个参数 start :记录开始位置 length:每页记录数
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询总记录数
     * @return
     */
    int count(T entity);

}
