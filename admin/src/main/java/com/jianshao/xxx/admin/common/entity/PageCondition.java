package com.jianshao.xxx.admin.common.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import org.jetbrains.annotations.Contract;

/**
 * 分页条件（参考JqGrid插件）
 */
@Data
public class PageCondition<T> {
    private int page = 1;//当前页码
    private int rows = 10;//页面大小
    private String sidx;//排序字段
    private String sord;//排序方式

    @Contract(pure = true)
    public QueryWrapper<T> buildQuery() {
        return null;
    }
}
