package com.woniuxy.lesson.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	/**
	 * �������������
	 */
	public String server() {
		ServerSocket ss = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String peer = null;// �Զ���Ϣ
		try {
			// �����������˿�
			ss = new ServerSocket(554);
			// �����׽��ֵ�����
			Socket accept = ss.accept();
			// ����һ��StringBuilder
			StringBuilder sb = new StringBuilder();
			// ��ȡ���������ֽ���
			inputStream = accept.getInputStream();
			// ���ֽ���ת��Ϊ�ַ���
			inputStreamReader = new InputStreamReader(inputStream, "GBK");
			// ��ȡ�ֽ���
			bufferedReader = new BufferedReader(inputStreamReader);
			String str = "";
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			// ��ȡ�ӿͻ��˷��͵�������������
			peer = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				// �ͷ���Դ
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
