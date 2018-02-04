package com.woniuxy.hibernate.entity;

import java.util.List;

public class PageInfo<T> {

	private int pageNum = 1;// ��ǰҳ
	private int pageSize = 5;// ÿҳ����
	private int total;// �ܼ�¼����
	private int totalPage;// ��ҳ��
	private List<T> datas;// ����

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
		// ������ҳ��
		this.totalPage = total / this.pageSize;
		if (total % pageSize != 0) {
			this.totalPage++;
		}
		//����pageNum
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
	 * ��ȡ��ʼλ��
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (this.pageNum - 1) * pageSize;
	}

	/**
	 * ��ȡÿҳ������
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
