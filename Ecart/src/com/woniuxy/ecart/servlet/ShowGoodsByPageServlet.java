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
	 * �����ҳ��ѯ��servlet
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����һ��map�������ڴ洢�û���Ϣ
		Map<String,Object> map=new HashMap<String,Object>();
		//��ȡҳ������Ĳ���
		String page=request.getParameter("page");
		//Ĭ�ϴӵ�һ�п�ʼȡֵ
		int index=0;
		//��ǰҳ��
		int a=Integer.parseInt(page);
		 index=(a-1)*6;

		//ʵ����ShowGoodsByPageService
		ShowGoodsByPageService goodService=new ShowGoodsByPageService();
		//ͨ������ʼ�������Ҷ�Ӧ����ʾ���ݣ�����showGoods���������showGoods()����,����һ��set���϶���
		Set<GoodsPO> goods= goodService.showGoods(index);
		//��ȡ�ܵ�ҳ��
		int totalPage=goodService.findTotalPage();
		//�淵�ص���ҳ��
		map.put("totalPage", totalPage);
		//�浱ǰҳ����Ʒ��Ϣ
		map.put("goods", goods);
		//��תֵ��Ʒչʾ����
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(),map);
		
	}

}
