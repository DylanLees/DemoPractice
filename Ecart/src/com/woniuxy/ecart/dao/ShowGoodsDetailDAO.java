package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.ecart.dao.po.GoodsPO;
import com.woniuxy.ecart.tools.JDBCDatabase;

public class ShowGoodsDetailDAO {

	/**
	 * �������ݿ�ͨ����Ʒid��ѯ��Ʒ����
	 * @param goodsId
	 * @return
	 */
	public GoodsPO findDetailById(String goodsId) {
		GoodsPO goods=new GoodsPO();
		// ��ȡ���ݿ�����
				JDBCDatabase jdbc = new JDBCDatabase();
				Connection con = jdbc.getConnection();
				// ����sql��䣬ͨ��indexȡָ����������
				String sql = "select * from goods where id=?";// 
				try {
					// ����sql���Ԥ����״̬
					PreparedStatement state = con.prepareStatement(sql);
					// ��state��������Ĳ����󶨶�Ӧ��ֵ
					state.setString(1, goodsId);
					// ����һ�������
					ResultSet re = state.executeQuery();
					// �жϸý�������Ƿ����Ԫ��
					while (re.next()) {
						// ����goods�����������Ե�ֵ
						goods.setId(re.getInt("id"));
						goods.setGoodsName(re.getString("goodsName"));
						goods.setPrice(re.getString("price"));
						goods.setInventory(re.getString("inventory"));
						goods.setFeature(re.getString("feature"));
						goods.setProduct_site(re.getString("product_site"));
						goods.setPicture_name(re.getString("picture_name"));						
					}
					

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					// �ر����ݿ�����
					jdbc.closeConnection(con);
				}
				//����һ���洢��Ʒ��ϸ��Ϣ�Ķ���
				return goods;
	}

}
