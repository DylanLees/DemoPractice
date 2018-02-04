package com.woniuxy.ecart.service;


import com.woniuxy.ecart.dao.ShowGoodsDetailDAO;
import com.woniuxy.ecart.dao.po.GoodsPO;

/**
 * 进行商品详情查找的逻辑判断。
 * @author Administrator
 *
 */
public class ShowGoodsDetailService {


	public GoodsPO findDetailById(String goodsId) {
		//通过实例化一个ShowGoodsDetailDAO的对象去调用里面的findDetailById(goodsId)方法查询商品详情并返回一个GoodsPO对象。
		GoodsPO goods  =new ShowGoodsDetailDAO().findDetailById(goodsId);
		return goods;
	}

}
