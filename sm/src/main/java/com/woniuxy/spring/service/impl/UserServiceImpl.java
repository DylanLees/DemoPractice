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
@Transactional(readOnly = true) // realOnlyĬ��ֵΪfalse
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Resource(name = "userMapper") // ע��userMapper����
	@Override
	public void setMapper(Mapper<User> mapper) {
		super.setMapper(mapper);
	}

	/**
	 * �û���¼��Ϣ��֤
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public User validateUserInfo(String user_name, String user_pass) {
		// �û�����md5����
		user_pass = DigestUtils.md5DigestAsHex(user_pass.getBytes());

		Example example = new Example(User.class);
		example.createCriteria().andCondition("user_name=", user_name).andCondition("user_pass=", user_pass);
		List<User> user = this.findByExample(example);

		return user.size() > 0 && user != null ? user.get(0) : null;

	}

	/**
	 * ��д�����û����ݵķ���
	 */
	@Transactional(readOnly = false)
	@Override
	public int insert(User t) {
		// ��������û�������м��ܴ���
		t.setUser_pass(DigestUtils.md5DigestAsHex(t.getUser_pass().getBytes()));
		return super.insert(t);
	}

}
