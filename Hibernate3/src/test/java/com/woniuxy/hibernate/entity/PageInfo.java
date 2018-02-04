package com.woniuxy.hibernate.entity;

import java.util.List;

/**
 * ����һ�����͵���
 * @author Administrator
 *
 * @param <T>
 */
public class PageInfo<T> {
	//�����Ա����
	private int pageNum=1;//��ǰҳ��
	private int pageSize=4;//��ʾÿҳ������
	private int totalRow;//�ܵ�����
	private int totalPage;//�ܵ�ҳ��
	private List<T> datas;//����
	
	
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
		//�����ܵ�ҳ��
		this.totalPage=totalRow/this.pageSize;
		if(totalRow%this.pageSize!=0){
			//�ܵ�ҳ��+1
			totalPage++;
		}
		//��ǰҳ��ֻ����1���ܵ�ҳ��totalPage֮��
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
	 * ��ȡ��ǰҳ����ʼλ��
	 */
	public int getFirstResult(){
		return(this.pageNum-1)*pageSize;
	}
	/**
	 * ��ȡÿҳ����ʾ����
	 */
	public int getMaxResult(){
		return this.pageSize;
	}
	/**
	 * �����жϵ�һҳ�ķ���
	 */
	public boolean getFirstPage(){
		//���������򷵻�booleanֵΪtrue
		return pageNum==1;
	}
	/**
	 * �����ж����һҳ�ķ���
	 */
	public boolean getLastPage(){
		//���������򷵻�booleanֵΪtrue
		return pageNum==totalPage;
	}
	
	
}
