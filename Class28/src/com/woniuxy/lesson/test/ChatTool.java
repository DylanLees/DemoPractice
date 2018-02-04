package com.woniuxy.lesson.test;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatTool {
	/**
	 * 定义客户端方法
	 */
	// 实例化扫描器
	public static Scanner sc = new Scanner(System.in);
	// 实例化ChatTool类
	public static ChatTool chatTool = new ChatTool();

	public static void main(String[] args) throws Exception {
		String peerip = chatTool.sendMessage();
		// 获取本机ip
		InetAddress localHost = InetAddress.getLocalHost();
		String lip = localHost.toString();// 将ip转换为字符串
		if (lip != peerip) {
			chatTool.getMessage();
		}

	}

	/**
	 * 定义接收消息的方法
	 */
	public void getMessage() {
		// 获取对端发送的消息
		String serverMessage = chatTool.getServer();
		if (serverMessage != null) {
			// 输出对端发送的消息
			System.out.println("小明发送了消息给您:");
			System.out.println(serverMessage);
		}
	}

	/**
	 * 定义客户端发送消息的方法
	 * 
	 * @throws Exception
	 */
	public String sendMessage() throws Exception {
		// 获取本机ip
		InetAddress localHost = InetAddress.getLocalHost();
		String ip = localHost.toString();// 将ip转换为字符串
		while (true) {
			// 请输入聊天信息
			System.out.println("请输入聊天信息");
			// 扫描键盘输入的聊天信息
			String content = sc.next();
			// 在调用客户端发送信息方法的时候传输参数为从键盘获取的信息
			String peerip = chatTool.client_1(content, ip);
			return peerip;
		}
	}

	/**
	 * 定义获取服务器返回值的方法
	 */
	public String getServer() {
		ChatServer chatServer = new ChatServer();
		String serverData = chatServer.server();// 获取服务器从客户端接收的数据
		return serverData;
	}

	/**
	 * 客户端1
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String client_1(String content, String ip) throws Exception {
		// 获取套接字
		Socket soc = null;
		soc = new Socket(ip, 554);
		// 通过套接字获取输出流
		OutputStream outputStream = soc.getOutputStream();
		// 准备要写出的byte数组
		byte[] bytes = content.getBytes("GBK");
		// 写出数据
		outputStream.write(bytes);
		// 释放资源
		soc.close();
		// 返回输出的值
		String peerip = ip;

		return peerip;

	}

	// /**
	// * 客户端2
	// */
	// public String client_2(String content) throws Exception {
	// // 获取套接字
	// Socket soc = null;
	// soc = new Socket("192.168.0.128", 554);
	// // 通过套接字获取输出流
	// OutputStream outputStream = soc.getOutputStream();
	// // 准备要写出的byte数组
	// byte[] bytes = content.getBytes("GBK");
	// // 写出数据
	// outputStream.write(bytes);
	// // 释放资源
	// soc.close();
	// // 返回输出的值
	// return outputStream.toString();
	//
	// }

}
