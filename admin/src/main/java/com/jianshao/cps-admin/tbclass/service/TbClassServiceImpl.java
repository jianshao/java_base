package com.jianshao.xxx.admin.tbclass.service;

import com.jianshao.xxx.admin.common.service.CommonServiceImpl;
import com.jianshao.xxx.admin.tbclass.controller.TbClassReq;
import com.jianshao.xxx.admin.tbclass.entity.TbClass;
import com.jianshao.xxx.admin.tbclass.entity.TbClassVo;
import com.jianshao.xxx.admin.tbclass.mapper.TbClassMapper;
import com.jianshao.xxx.admin.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程信息表 服务实现类
 * </p>
 *
 * @author jianshao
 * @since 2022-05-07
 */
@Service
public class TbClassServiceImpl extends CommonServiceImpl<TbClassReq, TbClassVo, TbClass> implements TbClassService {

    @Autowired
    private TbClassMapper tbClassMapper;


    public ClassResult getById(Integer classId, Integer userId) throws Exception {
        //课程基础信息
        TbClassVo tbClassVo = get(classId.toString());
        ClassResult result = CopyUtil.copy(tbClassVo, ClassResult.class);


        return result;
    }

    public List<ClassResult> list(Integer userId) throws Exception {
        List<TbClassVo> tbClassVos = list(new TbClassReq());
        List<ClassResult> classResults = CopyUtil.copyList(tbClassVos, ClassResult.class);
        for (ClassResult classResult : classResults) {
            Integer classId = classResult.getId();
        }
        return classResults;
    }
}
