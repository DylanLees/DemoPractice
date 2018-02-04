package com.woniuxy.hibernate.entity;

import java.util.List;

public class PageInfo<T> {

	private int pageNum = 1;// 当前页
	private int pageSize = 5;// 每页条数
	private int total;// 总记录条数
	private int totalPage;// 总页数
	private List<T> datas;// 数据

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		// 计算总页数
		this.totalPage = total / this.pageSize;
		if (total % pageSize != 0) {
			this.totalPage++;
		}
		//修正pageNum
		if (pageNum < 1) {
			pageNum = 1;
		}
		if (pageNum > this.totalPage) {
			pageNum = totalPage;
		}
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 获取起始位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.pageNum - 1) * pageSize;
	}

	/**
	 * 获取每页的条数
	 * 
	 * @return
	 */
	public int getMaxResult() {
		return this.pageSize;
	}

	public boolean isFirst() {
		return this.pageNum == 1;
	}

	public boolean isLast() {
		return this.pageNum == this.totalPage;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + ", totalPage="
				+ totalPage + ", datas=" + datas + "]";
	}

}
