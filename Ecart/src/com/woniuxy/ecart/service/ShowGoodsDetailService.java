package com.woniuxy.ecart.service;


import com.woniuxy.ecart.dao.ShowGoodsDetailDAO;
import com.woniuxy.ecart.dao.po.GoodsPO;

/**
 * ������Ʒ������ҵ��߼��жϡ�
 * @author Administrator
 *
 */
public class ShowGoodsDetailService {


	public GoodsPO findDetailById(String goodsId) {
		//ͨ��ʵ����һ��ShowGoodsDetailDAO�Ķ���ȥ���������findDetailById(goodsId)������ѯ��Ʒ���鲢����һ��GoodsPO����
		GoodsPO goods  =new ShowGoodsDetailDAO().findDetailById(goodsId);
		return goods;
	}

}
