package com.jianshao.xxx.admin.tbclass.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jianshao.xxx.admin.common.entity.PageCondition;
import com.jianshao.xxx.admin.tbclass.entity.TbClass;
import lombok.Data;

@Data
public class TbClassReq extends PageCondition<TbClass> {
    private Integer userId;
    public QueryWrapper<TbClass> buildQuery() {
        QueryWrapper<TbClass> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("user_id", userId);
        return queryWrapper;
    }
}
