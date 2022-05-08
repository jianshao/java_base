package com.jianshao.xxx.admin.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象（参考JqGrid插件）
 */
@Data
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码数
     */
    private long currPage;
    /**
     * 每页显示的记录数
     */
    private long pageSize;
    /**
     * 开始行号
     */
    private long startRow;
    /**
     * 结束行号
     */
    private long endRow;
    /**
     *  总记录数
     */
    private long totalRecords;
    /**
     *  总页码数
     */
    private int totalPages;
    /**
     *  导航条 页码数
     */
    private int navigatePages;
    /**
     * 导航条 具体页码数
     */
    private int[] navigatePageNums;
    /**
     *  导航条上的开始页
     */
    private int navigateStartPage;
    /**
     *  导航条上的结束页
     */
    private int navigateEndPage;
    /**
     *  首页页码
     */
    private int firstPage;
    /**
     *  上一页页码
     */
    private int previousPage;
    /**
     *  下一页页码
     */
    private int nextPage;
    /**
     *  尾页页码
     */
    private int lastPage;
    /**
     *  是否有上一页
     */
    private boolean hasPreviousPage = false;
    /**
     *  是否有下一页
     */
    private boolean hasNextPage = false;
    /**
     * 是否为首页
     */
    private boolean isFirstPage = false;
    /**
     * 是否为最后一页
     */
    private boolean isLastPage = false;

    // 存放本次分页查询出来的数据
    private List<T> list;

    private int getTotalPage() {
        long total = totalRecords / pageSize;
        if (totalRecords % pageSize != 0) {
            total += 1;
        }
        return (int)total;
    }
    /**
     */
    public PageInfo(long currPage, long pageSize, List<T> list) {
        this.setList(list);//数据部分
        this.setCurrPage(currPage);// 当前页码
        this.setPageSize(pageSize);// 每页显示的记录数
        this.setTotalRecords(list.size());// 总记录数
        int total = this.getTotalPage();
        this.setTotalPages(total);// 总页码数
        this.setNavigatePages(total);// 导航条 页码数

        // 当前页码大于总页码数时，当前页码=总页码数
        if (this.currPage > this.totalPages) {
            this.currPage = this.totalPages;
        }
        // 开始行号
        this.startRow = ((long) this.currPage * this.pageSize)-(this.pageSize-1);
        // 结束行号
        this.endRow = (long) this.currPage * this.pageSize;
        //当结束行号>总行数时，结束行号=总行数
        if(this.endRow > this.totalRecords) {
            this.endRow = this.totalRecords;
        }
        // 导航条 开始页码和结束页码
        this.navigateStartPage = (this.currPage - this.navigatePages / 2) > 0 ? (int) (this.currPage - this.navigatePages / 2) : 1;
        this.navigateEndPage = this.navigateStartPage+this.navigatePages;
        if(this.navigateEndPage>this.totalPages){
            this.navigateEndPage = this.totalPages;
            if(this.navigateEndPage>this.navigatePages){
                this.navigateStartPage = this.navigateEndPage-this.navigatePages+1;
            }
        }
        //导航条具体页数
        this.navigatePageNums = new int[this.navigatePages];
        for(int i=this.navigateStartPage; i<=this.navigateEndPage; i++){
            this.navigatePageNums[i-this.navigateStartPage] = i;
        }

        this.firstPage = 1;//设置首页
        this.lastPage = this.totalPages;//设置尾页
        this.isFirstPage = this.currPage==this.firstPage;//是否为第一页
        this.isLastPage = this.currPage==this.lastPage;//是否为最后一页
        // 设置上一页
        if (this.currPage > 1) {
            this.hasPreviousPage = true;
            this.previousPage = (int) (this.currPage - 1);
        }
        // 设置下一页
        if (this.currPage < this.totalPages) {
            this.hasNextPage = true;
            this.nextPage = (int) (this.currPage + 1);
        }
    }
}
