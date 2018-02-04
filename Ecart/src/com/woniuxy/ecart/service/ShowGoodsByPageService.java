package com.woniuxy.ecart.service;

import java.util.Set;

import com.woniuxy.ecart.dao.GoodsDAO;
import com.woniuxy.ecart.dao.po.GoodsPO;

/**
 * ��Ʒ��ҳչʾ���߼��ж�
 * @author Administrator
 *
 */
public class ShowGoodsByPageService {
/**
 * ����չʾ��Ʒ��Ϣ�ķ���
 * @param index
 * @return
 */
	public Set<GoodsPO> showGoods(int index) {
		Set<GoodsPO> goods=null;//Ĭ��ֵΪ0
		//ʵ����GoodsPO
		GoodsDAO gdo=new GoodsDAO();
		//����gdo���������findGoodsByIndex()
		goods=gdo.findGoodsByIndex(index);
		return goods;
	}
/**
 * �����ѯ��Ʒչʾ����ҳ��
 * @return
 */
	public int findTotalPage() {
		//����Ĭ�ϵ���ҳ��Ϊ1ҳ
		int totalPage=1;
		//ʵ����GoodsDAO
		GoodsDAO gdao=new GoodsDAO();
		//����gdao���������findTotalRow()����ȡ�ܵ�����
		int totalRow=gdao.findTotalRow();
		//��ȡ�ܵ�ҳ��,ÿҳ��ʾ6�����ݡ�
		totalPage=totalRow%6==0?totalRow/6:totalRow/6+1;
		return totalPage;
	}

}
