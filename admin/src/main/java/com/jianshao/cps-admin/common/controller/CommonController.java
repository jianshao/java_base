package com.jianshao.xxx.admin.common.controller;

import com.jianshao.xxx.admin.common.entity.PageInfo;
import com.jianshao.xxx.admin.common.entity.Result;
import com.jianshao.xxx.admin.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 通用controller
 * @param <R> 请求体
 * @param <V> vo对象
 * @param <T> entity实体
 */
public class CommonController<R, V, T> {

    @Autowired
    private CommonService<R,V,T> commonService;

    /*
        CRUD、分页、排序测试
     */

    @PostMapping("page")
    public Result<PageInfo<V>> page(@RequestBody R entityVo) {
        return Result.build(commonService.page(entityVo));
    }

    @PostMapping("list")
    public Result<List<V>> list(@RequestBody R entityVo) {
        return Result.build(commonService.list(entityVo));
    }

    @GetMapping("get/{id}")
    public Result<V> get(@PathVariable("id") String id) {
        return Result.build(commonService.get(id));
    }

    @PostMapping("save")
    public Result<V> save(@RequestBody V entityVo) {
        return Result.build(commonService.save(entityVo));
    }

    @GetMapping("delete/{id}")
    public Result<String> delete( @PathVariable("id") String id) {
        return Result.build(commonService.delete(id));
    }
}
