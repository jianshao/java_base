package com.jianshao.xxx.admin.tbclass.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程信息表
 * </p>
 *
 * @author jianshao
 * @since 2022-05-07
 */
@Data
public class TbClass {

  /**
   * 课程id
   */
  //主键生成策略自动递增：type = IdType.AUTO，指定id回显
  @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

  /**
   * 课程名
   */
    private String name;

  /**
   * 课程封面图
   */
    private String image;

  /**
   * 课程详情页banner
   */
    private String banner;

  /**
   * 主讲人
   */
    private String owner;

  /**
   * 主讲人头像
   */
    private String ownerAvatar;

  /**
   * 创建时间
   */
    private Date createdTime;

  /**
   * 最后更新时间
   */
    private Date updatedTime;
}
