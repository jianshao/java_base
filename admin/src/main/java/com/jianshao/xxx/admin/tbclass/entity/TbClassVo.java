package com.jianshao.xxx.admin.tbclass.entity;

import java.util.Date;

import lombok.Data;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author jianshao
 * @since 2022-05-07
 */
@Data
public class TbClassVo{
    private Integer id;
    private String name;
    private String image;
    private String banner;
    private String owner;
    private String ownerAvatar;
    private Date createdTime;
    private Date updatedTime;
}
