package com.woniuxy.lesson.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetWorkTest implements Runnable {
	public static void main(String[] args) {
		NetWorkTest netWorkTest = new NetWorkTest();
		netWorkTest.run();
	}

	/**
	 * 定义客户端方法
	 */
	public void client() {
		// 创建一个套接字的实例
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			socket = new Socket("127.0.0.1", 554);
			// 通过套接字获取输出流
			outputStream = socket.getOutputStream();
			// 准备要写出的byte数组
			byte[] bytes = "hello".getBytes();
			// 写出数据
			outputStream.write(bytes);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 关闭流和套接字
				socket.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		client();
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 定义服务器方法
	 */
	public void server() {
		ServerSocket ss = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		try {
			// 监听客户端所在端口
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
			System.out.println(sb.toString());

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
	}
}
