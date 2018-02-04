package com.woniuxy.ecart.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.dao.po.GoodsPO;
import com.woniuxy.ecart.service.ShowGoodsByPageService;

public class ShowGoodsByPageServlet extends HttpServlet {

	
	/**
	 * 定义分页查询的servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个map对象用于存储用户信息
		Map<String,Object> map=new HashMap<String,Object>();
		//获取页面请求的参数
		String page=request.getParameter("page");
		//默认从第一行开始取值
		int index=0;
		//当前页数
		int a=Integer.parseInt(page);
		 index=(a-1)*6;

		//实例化ShowGoodsByPageService
		ShowGoodsByPageService goodService=new ShowGoodsByPageService();
		//通过传起始行数查找对应的显示数据，调用showGoods对象里面的showGoods()方法,返回一个set集合对象
		Set<GoodsPO> goods= goodService.showGoods(index);
		//获取总的页数
		int totalPage=goodService.findTotalPage();
		//存返回的总页数
		map.put("totalPage", totalPage);
		//存当前页的商品信息
		map.put("goods", goods);
		//跳转值商品展示界面
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(),map);
		
	}

}
