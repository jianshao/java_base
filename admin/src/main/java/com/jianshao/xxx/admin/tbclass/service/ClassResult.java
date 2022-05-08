package com.jianshao.xxx.admin.tbclass.service;

import com.jianshao.xxx.admin.tbclass.entity.TbClassVo;
import lombok.Data;

@Data
public class ClassResult extends TbClassVo {
    private Integer joinCount = 0; //加入人数，也即热度
    private Integer status = 0; //加入状态，0-未加入，1-已加入
}
