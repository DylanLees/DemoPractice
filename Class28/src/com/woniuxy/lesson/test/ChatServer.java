package com.woniuxy.lesson.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	/**
	 * 定义服务器方法
	 */
	public String server() {
		ServerSocket ss = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String peer = null;// 对端信息
		try {
			// 监听服务器端口
			ss = new ServerSocket(554);
			// 接收套接字的数据
			Socket accept = ss.accept();
			// 创建一个StringBuilder
			StringBuilder sb = new StringBuilder();
			// 获取输入流的字节流
			inputStream = accept.getInputStream();
			// 把字节流转换为字符流
			inputStreamReader = new InputStreamReader(inputStream, "GBK");
			// 读取字节流
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = "";
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			// 获取从客户端发送到服务器的内容
			peer = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				// 释放资源
				inputStream.close();
				ss.close();
				bufferedReader.close();
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return peer;
	}
}
