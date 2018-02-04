package com.woniuxy.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.woniuxy.spring.entity.User;
import com.woniuxy.spring.service.UserService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@Service("userService")
@Transactional(readOnly = true) // realOnly默认值为false
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Resource(name = "userMapper") // 注入userMapper对象
	@Override
	public void setMapper(Mapper<User> mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 用户登录信息验证
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User validateUserInfo(String user_name, String user_pass) {
		// 用户密码md5加密
		user_pass = DigestUtils.md5DigestAsHex(user_pass.getBytes());

		Example example = new Example(User.class);
		example.createCriteria().andCondition("user_name=", user_name).andCondition("user_pass=", user_pass);
		List<User> user = this.findByExample(example);

		return user.size() > 0 && user != null ? user.get(0) : null;

	}

	/**
	 * 重写插入用户数据的方法
	 */
	@Transactional(readOnly = false)
	@Override
	public int insert(User t) {
		// 对输入的用户密码进行加密处理
		t.setUser_pass(DigestUtils.md5DigestAsHex(t.getUser_pass().getBytes()));
		return super.insert(t);
	}

}
