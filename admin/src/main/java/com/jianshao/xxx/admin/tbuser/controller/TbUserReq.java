package com.jianshao.xxx.admin.tbuser.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jianshao.xxx.admin.common.entity.PageCondition;
import com.jianshao.xxx.admin.tbuser.entity.TbUser;

public class TbUserReq extends PageCondition<TbUser> {
    public QueryWrapper<TbUser> buildQuery() {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        return queryWrapper;
    }
}
