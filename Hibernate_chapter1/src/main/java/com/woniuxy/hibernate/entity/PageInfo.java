package com.woniuxy.hibernate.entity;

import java.util.List;

public class PageInfo<T> {
	public static final Integer DEFAULT_SIZE = 10;// ���õ�ǰҳ��ʾ������Ĭ��ֵ��
	private Integer id;
	private Integer totalRow;// ���ݿ���������
	private Integer totalPage;// �ܵ�ҳ��
	private Integer currPage = 1;// ��ǰҳ��
	private Integer pageSize = DEFAULT_SIZE;// ��ǰҳ��ʾ��������
	private boolean isFirst;// �Ƿ��һҳ
	private boolean isLast;// �Ƿ����һҳ
	private List<T> datas;// ����
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
