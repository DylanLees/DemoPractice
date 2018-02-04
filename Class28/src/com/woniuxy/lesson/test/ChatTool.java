package com.woniuxy.lesson.test;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatTool {
	/**
	 * ����ͻ��˷���
	 */
	// ʵ����ɨ����
	public static Scanner sc = new Scanner(System.in);
	// ʵ����ChatTool��
	public static ChatTool chatTool = new ChatTool();

	public static void main(String[] args) throws Exception {
		String peerip = chatTool.sendMessage();
		// ��ȡ����ip
		InetAddress localHost = InetAddress.getLocalHost();
		String lip = localHost.toString();// ��ipת��Ϊ�ַ���
		if (lip != peerip) {
			chatTool.getMessage();
		}

	}

	/**
	 * ���������Ϣ�ķ���
	 */
	public void getMessage() {
		// ��ȡ�Զ˷��͵���Ϣ
		String serverMessage = chatTool.getServer();
		if (serverMessage != null) {
			// ����Զ˷��͵���Ϣ
			System.out.println("С����������Ϣ����:");
			System.out.println(serverMessage);
		}
	}

	/**
	 * ����ͻ��˷�����Ϣ�ķ���
	 * 
	 * @throws Exception
	 */
	public String sendMessage() throws Exception {
		// ��ȡ����ip
		InetAddress localHost = InetAddress.getLocalHost();
		String ip = localHost.toString();// ��ipת��Ϊ�ַ���
		while (true) {
			// ������������Ϣ
			System.out.println("������������Ϣ");
			// ɨ����������������Ϣ
			String content = sc.next();
			// �ڵ��ÿͻ��˷�����Ϣ������ʱ�������Ϊ�Ӽ��̻�ȡ����Ϣ
			String peerip = chatTool.client_1(content, ip);
			return peerip;
		}
	}

	/**
	 * �����ȡ����������ֵ�ķ���
	 */
	public String getServer() {
		ChatServer chatServer = new ChatServer();
		String serverData = chatServer.server();// ��ȡ�������ӿͻ��˽��յ�����
		return serverData;
	}

	/**
	 * �ͻ���1
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String client_1(String content, String ip) throws Exception {
		// ��ȡ�׽���
		Socket soc = null;
		soc = new Socket(ip, 554);
		// ͨ���׽��ֻ�ȡ�����
		OutputStream outputStream = soc.getOutputStream();
		// ׼��Ҫд����byte����
		byte[] bytes = content.getBytes("GBK");
		// д������
		outputStream.write(bytes);
		// �ͷ���Դ
		soc.close();
		// ���������ֵ
		String peerip = ip;

		return peerip;

	}

	// /**
	// * �ͻ���2
	// */
	// public String client_2(String content) throws Exception {
	// // ��ȡ�׽���
	// Socket soc = null;
	// soc = new Socket("192.168.0.128", 554);
	// // ͨ���׽��ֻ�ȡ�����
	// OutputStream outputStream = soc.getOutputStream();
	// // ׼��Ҫд����byte����
	// byte[] bytes = content.getBytes("GBK");
	// // д������
	// outputStream.write(bytes);
	// // �ͷ���Դ
	// soc.close();
	// // ���������ֵ
	// return outputStream.toString();
	//
	// }

}
