package com.woniuxy.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 指定web环境资源
@ContextHierarchy({ @ContextConfiguration(locations = "classpath:beans.xml", name = "parent"),
		@ContextConfiguration(locations = "classpath:springmvc.xml", name = "child") })
public class LoginTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/**
	 * 实现模拟发送http请求
	 * 
	 * @throws Exception
	 */
	@Test
	public void login() throws Exception {
		// 模拟http请求
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.post("/login3.do?user_name=admin&user_pass=admin"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("success")).andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

}
