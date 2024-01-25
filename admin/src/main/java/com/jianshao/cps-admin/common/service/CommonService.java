package com.jianshao.xxx.admin.common.service;


import com.jianshao.xxx.admin.common.entity.PageInfo;

import java.util.List;

/**
 * 通用service接口
 * @param <V> vo对象
 * @param <T> entity实体
 */
public interface CommonService<R,V,T> {

    /**
     * page接口 分页、排序
     */
    PageInfo<V> page(R entityVo);

    /**
     * list接口，条件查询
     */
    List<V> list(R entityVo);

    /**
     * get接口，根据id查询
     */
    V get(String id);

    /**
     * save接口，vo无id为新增、vo有id为更新（只更新vo有值的属性）
     */
    V save(V entityVo);

    /**
     * delete接口，根据id删除
     */
    String delete(String id);
}
