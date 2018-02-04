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
 * 商品信息的查询
 * 
 * @author Administrator
 *
 */
public class GoodsDAO {
	/**
	 * 定义通过下标找到商品信息
	 * 
	 * @param index
	 * @return
	 */
	public Set<GoodsPO> findGoodsByIndex(int index) {
		// 创建一个set集合对象，用于存储商品信息
		Set<GoodsPO> goods = new HashSet<GoodsPO>();
		// 获取数据库连接
		JDBCDatabase jdbc = new JDBCDatabase();
		Connection con = jdbc.getConnection();
		// 创建sql语句，通过index取指定的行数。
		String sql = "select * from goods limit ?,6";// 从第？行开始查询，6行数据。
		try {
			// 创建sql语句预编译状态
			PreparedStatement state = con.prepareStatement(sql);
			// 给state对象里面的参数绑定对应的值
			state.setInt(1, index);
			// 返回一个结果集
			ResultSet re = state.executeQuery();
			// 判断该结果集中是否存在元素
			while (re.next()) {
				// 实例化GoodsPO
				GoodsPO gpo = new GoodsPO();
				// 设置gpo对象里面属性的值
				gpo.setId(re.getInt("id"));
				gpo.setGoodsName(re.getString("goodsName"));
				gpo.setPrice(re.getString("price"));
				gpo.setInventory(re.getString("inventory"));
				gpo.setFeature(re.getString("feature"));
				gpo.setProduct_site(re.getString("product_site"));
				gpo.setPicture_name(re.getString("picture_name"));
				// 将gpo对象里面的值添加到goods集合里面并返回
				goods.add(gpo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			jdbc.closeConnection(con);
		}

		return goods;
	}

	/***
	 * 定义查询数据库中所有商品的行数
	 * 
	 * @return
	 */
	public int findTotalRow() {
		int totalRow = 0;// 设置总的行数初始值为0
		// 获取数据库连接
		JDBCDatabase jdbc = new JDBCDatabase();
		Connection con=jdbc.getConnection();
		//创建sql语句查询行数
		String sql="select count(*) totalrow  from goods";
		try {
			//创建sql预编译状态
			PreparedStatement state=con.prepareStatement(sql);
			//执行executeQuery,返回一个结果集
			ResultSet re=state.executeQuery();
			while(re.next()){
				totalRow=re.getInt("totalRow");//获取总的行数
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//关闭数据库连接
			jdbc.closeConnection(con);
		}
		
		return totalRow;
	}

}
