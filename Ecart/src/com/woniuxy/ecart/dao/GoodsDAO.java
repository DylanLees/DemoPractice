package com.woniuxy.ecart.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.woniuxy.ecart.dao.po.GoodsPO;
import com.woniuxy.ecart.tools.JDBCDatabase;

/**
 * ��Ʒ��Ϣ�Ĳ�ѯ
 * 
 * @author Administrator
 *
 */
public class GoodsDAO {
	/**
	 * ����ͨ���±��ҵ���Ʒ��Ϣ
	 * 
	 * @param index
	 * @return
	 */
	public Set<GoodsPO> findGoodsByIndex(int index) {
		// ����һ��set���϶������ڴ洢��Ʒ��Ϣ
		Set<GoodsPO> goods = new HashSet<GoodsPO>();
		// ��ȡ���ݿ�����
		JDBCDatabase jdbc = new JDBCDatabase();
		Connection con = jdbc.getConnection();
		// ����sql��䣬ͨ��indexȡָ����������
		String sql = "select * from goods limit ?,6";// �ӵڣ��п�ʼ��ѯ��6�����ݡ�
		try {
			// ����sql���Ԥ����״̬
			PreparedStatement state = con.prepareStatement(sql);
			// ��state��������Ĳ����󶨶�Ӧ��ֵ
			state.setInt(1, index);
			// ����һ�������
			ResultSet re = state.executeQuery();
			// �жϸý�������Ƿ����Ԫ��
			while (re.next()) {
				// ʵ����GoodsPO
				GoodsPO gpo = new GoodsPO();
				// ����gpo�����������Ե�ֵ
				gpo.setId(re.getInt("id"));
				gpo.setGoodsName(re.getString("goodsName"));
				gpo.setPrice(re.getString("price"));
				gpo.setInventory(re.getString("inventory"));
				gpo.setFeature(re.getString("feature"));
				gpo.setProduct_site(re.getString("product_site"));
				gpo.setPicture_name(re.getString("picture_name"));
				// ��gpo���������ֵ��ӵ�goods�������沢����
				goods.add(gpo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			jdbc.closeConnection(con);
		}

		return goods;
	}

	/***
	 * �����ѯ���ݿ���������Ʒ������
	 * 
	 * @return
	 */
	public int findTotalRow() {
		int totalRow = 0;// �����ܵ�������ʼֵΪ0
		// ��ȡ���ݿ�����
		JDBCDatabase jdbc = new JDBCDatabase();
		Connection con=jdbc.getConnection();
		//����sql����ѯ����
		String sql="select count(*) totalrow  from goods";
		try {
			//����sqlԤ����״̬
			PreparedStatement state=con.prepareStatement(sql);
			//ִ��executeQuery,����һ�������
			ResultSet re=state.executeQuery();
			while(re.next()){
				totalRow=re.getInt("totalRow");//��ȡ�ܵ�����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//�ر����ݿ�����
			jdbc.closeConnection(con);
		}
		
		return totalRow;
	}

}
