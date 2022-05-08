package com.jianshao.xxx.admin.tbclass.service;

import com.jianshao.xxx.admin.common.service.CommonService;
import com.jianshao.xxx.admin.tbclass.controller.TbClassReq;
import com.jianshao.xxx.admin.tbclass.entity.TbClass;
import com.jianshao.xxx.admin.tbclass.entity.TbClassVo;

import java.util.List;

/**
 * <p>
 * 课程信息表 服务类
 * </p>
 *
 * @author jianshao
 * @since 2022-05-07
 */
public interface TbClassService  extends CommonService<TbClassReq, TbClassVo, TbClass> {

    ClassResult getById(Integer classId, Integer userId) throws Exception;
    List<ClassResult> list(Integer userId) throws Exception;
}