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
 * չʾ��Ʒ�����servlet
 */
public class ShowGoodsDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ���goodsId
		String goodsId=request.getParameter("goodsId");
		//����һ��map����
		Map<String ,Object> map=new HashMap<String,Object>();
		//ʵ����ShowGoodsDetailService
		ShowGoodsDetailService detailService=new ShowGoodsDetailService();
		//����detailService���������findDetailById()������������һ������
		GoodsPO goods  =detailService.findDetailById(goodsId);
		//��good��������map��������
		map.put("goods", goods);
		//
		ObjectMapper om = new ObjectMapper();
		//����һ�������ajax����
		om.writeValue(response.getOutputStream(),map);
		
		
		
	}

}
