package com.woniuxy.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.ecart.dao.po.GoodsPO;
import com.woniuxy.ecart.tools.JDBCDatabase;

public class ShowGoodsDetailDAO {

	/**
	 * 连接数据库通过商品id查询商品详情
	 * @param goodsId
	 * @return
	 */
	public GoodsPO findDetailById(String goodsId) {
		GoodsPO goods=new GoodsPO();
		// 获取数据库连接
				JDBCDatabase jdbc = new JDBCDatabase();
				Connection con = jdbc.getConnection();
				// 创建sql语句，通过index取指定的行数。
				String sql = "select * from goods where id=?";// 
				try {
					// 创建sql语句预编译状态
					PreparedStatement state = con.prepareStatement(sql);
					// 给state对象里面的参数绑定对应的值
					state.setString(1, goodsId);
					// 返回一个结果集
					ResultSet re = state.executeQuery();
					// 判断该结果集中是否存在元素
					while (re.next()) {
						// 设置goods对象里面属性的值
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
					// 关闭数据库连接
					jdbc.closeConnection(con);
				}
				//返回一个存储商品详细信息的对象。
				return goods;
	}

}
