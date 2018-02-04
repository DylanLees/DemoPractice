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
	 * ����ͻ��˷���
	 */
	public void client() {
		// ����һ���׽��ֵ�ʵ��
		Socket socket = null;
		OutputStream outputStream = null;
		try {
			socket = new Socket("127.0.0.1", 554);
			// ͨ���׽��ֻ�ȡ�����
			outputStream = socket.getOutputStream();
			// ׼��Ҫд����byte����
			byte[] bytes = "hello".getBytes();
			// д������
			outputStream.write(bytes);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �ر������׽���
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
	 * �������������
	 */
	public void server() {
		ServerSocket ss = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		try {
			// �����ͻ������ڶ˿�
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
			System.out.println(sb.toString());

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
	}
}
