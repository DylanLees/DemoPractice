package com.woniuxy.ecart.service;

import java.util.Set;

import com.woniuxy.ecart.dao.GoodsDAO;
import com.woniuxy.ecart.dao.po.GoodsPO;

/**
 * 商品分页展示的逻辑判断
 * @author Administrator
 *
 */
public class ShowGoodsByPageService {
/**
 * 定义展示商品信息的方法
 * @param index
 * @return
 */
	public Set<GoodsPO> showGoods(int index) {
		Set<GoodsPO> goods=null;//默认值为0
		//实例化GoodsPO
		GoodsDAO gdo=new GoodsDAO();
		//调用gdo对象里面的findGoodsByIndex()
		goods=gdo.findGoodsByIndex(index);
		return goods;
	}
/**
 * 定义查询商品展示的总页数
 * @return
 */
	public int findTotalPage() {
		//设置默认的总页数为1页
		int totalPage=1;
		//实例化GoodsDAO
		GoodsDAO gdao=new GoodsDAO();
		//调用gdao对象里面的findTotalRow()，获取总的行数
		int totalRow=gdao.findTotalRow();
		//获取总的页数,每页显示6行数据。
		totalPage=totalRow%6==0?totalRow/6:totalRow/6+1;
		return totalPage;
	}

}
