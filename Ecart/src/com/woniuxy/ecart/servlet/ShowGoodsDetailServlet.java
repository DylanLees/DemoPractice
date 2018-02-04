package com.woniuxy.ecart.servlet;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.ecart.dao.po.GoodsPO;
import com.woniuxy.ecart.service.ShowGoodsDetailService;
/**
 * 展示商品详情的servlet
 */
public class ShowGoodsDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的goodsId
		String goodsId=request.getParameter("goodsId");
		//创建一个map对象
		Map<String ,Object> map=new HashMap<String,Object>();
		//实例化ShowGoodsDetailService
		ShowGoodsDetailService detailService=new ShowGoodsDetailService();
		//调用detailService对象里面的findDetailById()方法，并返回一个对象
		GoodsPO goods  =detailService.findDetailById(goodsId);
		//将good对象存放在map集合里面
		map.put("goods", goods);
		//
		ObjectMapper om = new ObjectMapper();
		//返回一个结果到ajax里面
		om.writeValue(response.getOutputStream(),map);
		
		
		
	}

}
