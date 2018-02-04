package com.woniuxy.mybatis.entity;


import java.util.List;

public interface UserMapper {

	void save(User user);

	void update(User user );

	void delete(int id);

	User findInfoById(int id);

	List<User> findInfoByName(String userName);
	void batchInsert(List<User> user);
	
}
