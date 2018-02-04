package com.woniuxy.hibernate.entity;

import java.util.List;

public class PageInfo<T> {
	public static final Integer DEFAULT_SIZE = 10;// 设置当前页显示的条数默认值。
	private Integer id;
	private Integer totalRow;// 数据库中总行数
	private Integer totalPage;// 总的页数
	private Integer currPage = 1;// 当前页码
	private Integer pageSize = DEFAULT_SIZE;// 当前页显示数据条数
	private boolean isFirst;// 是否第一页
	private boolean isLast;// 是否最后一页
	private List<T> datas;// 数据
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		
		this.totalPage = totalPage;
	}
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public static Integer getDefaultSize() {
		return DEFAULT_SIZE;
	}

	
}
