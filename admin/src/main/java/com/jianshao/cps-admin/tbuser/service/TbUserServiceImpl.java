package com.jianshao.xxx.admin.tbuser.service;

import com.jianshao.xxx.admin.common.service.CommonServiceImpl;
import com.jianshao.xxx.admin.tbuser.controller.TbUserReq;
import com.jianshao.xxx.admin.tbuser.entity.TbUser;
import com.jianshao.xxx.admin.tbuser.entity.TbUserVo;
import com.jianshao.xxx.admin.tbuser.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author huanzi-qch
 * @since 2020-08-25
 */
@Service
public class TbUserServiceImpl  extends CommonServiceImpl<TbUserReq,TbUserVo, TbUser> implements TbUserService {

    @Autowired
    private TbUserMapper tbuserMapper;
}
