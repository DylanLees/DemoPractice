package com.woniuxy.hibernate.entity;

import java.util.List;

/**
 * 定义一个范型的类
 * @author Administrator
 *
 * @param <T>
 */
public class PageInfo<T> {
	//定义成员变量
	private int pageNum=1;//当前页码
	private int pageSize=4;//显示每页的条数
	private int totalRow;//总的行数
	private int totalPage;//总的页数
	private List<T> datas;//数据
	
	
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
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		//计算总的页数
		this.totalPage=totalRow/this.pageSize;
		if(totalRow%this.pageSize!=0){
			//总的页数+1
			totalPage++;
		}
		//当前页码只能在1到总的页数totalPage之间
		if(this.pageNum<1){
			pageNum=1;
		}
		if(this.pageNum>this.totalPage){
			pageNum=this.totalPage;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	/**
	 * 获取当前页的起始位置
	 */
	public int getFirstResult(){
		return(this.pageNum-1)*pageSize;
	}
	/**
	 * 获取每页的显示条数
	 */
	public int getMaxResult(){
		return this.pageSize;
	}
	/**
	 * 定义判断第一页的方法
	 */
	public boolean getFirstPage(){
		//满足条件则返回boolean值为true
		return pageNum==1;
	}
	/**
	 * 定义判断最后一页的方法
	 */
	public boolean getLastPage(){
		//满足条件则返回boolean值为true
		return pageNum==totalPage;
	}
	
	
}
