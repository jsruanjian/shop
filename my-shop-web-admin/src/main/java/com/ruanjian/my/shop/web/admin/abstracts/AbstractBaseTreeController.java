package com.ruanjian.my.shop.web.admin.abstracts;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.ruanjian.my.shop.commons.dto.BaseResult;
import com.ruanjian.my.shop.commons.persistence.BaseEntity;
import com.ruanjian.my.shop.commons.persistence.BaseTreeEntity;
import com.ruanjian.my.shop.commons.persistence.BaseTreeService;
import com.ruanjian.my.shop.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public  abstract  class AbstractBaseTreeController<T extends BaseTreeEntity,S extends BaseTreeService<T>> {
    @Autowired
    protected S service;

    /**
     * 跳转列表页
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     *
     * @return
     */
     public abstract  String form(T entity);

    /**
     * 保存
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
     public abstract String save(T entity , Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);
    /**
     * 树形结构
     * @return
     */
     public abstract List<T> treeData(Long id);

    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId  父节点的ID
     */
    protected void sortList(List<T> sourceList,List<T> targetList ,Long parentId){
        for(T sourceEntity:sourceList){
            if(sourceEntity.getParent().getId().equals(parentId)){
                targetList.add(sourceEntity);
                //判断有没有子节点，如果有则继续追加
                if(sourceEntity.getIsParent()){
                    for (T currentEntity:sourceList){
                        if(currentEntity.getParent().getId().equals(sourceEntity.getId())){
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
