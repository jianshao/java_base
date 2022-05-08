package com.jianshao.xxx.admin.tbuser.controller;

import com.jianshao.xxx.admin.common.controller.CommonController;
import com.jianshao.xxx.admin.tbuser.entity.TbUser;
import com.jianshao.xxx.admin.tbuser.entity.TbUserVo;
import com.jianshao.xxx.admin.tbuser.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@RestController
@RequestMapping("/tbUser/")
public class TbUserController extends CommonController<TbUserReq,TbUserVo, TbUser> {

    @Autowired
    private TbUserService tbUserService;

}