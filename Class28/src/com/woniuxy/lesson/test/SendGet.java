package com.woniuxy.lesson.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ģ�ⷢ������
 * 
 * @author Administrator
 *
 */
public class SendGet {

	public static void main(String[] args) throws Exception {
		SendGet sg = new SendGet();
		sg.sendGet();
	}

	/**
	 * ���巢������ķ��� ����java.net
	 * 
	 * @throws MalformedURLException
	 */
	public void sendGet() throws Exception {
		// ����һ��StringBuilder
		// StringBuilder stringBuilder = new StringBuilder();
		// ����һ���ļ�����
		File file = new File("g:/jdmall.txt");
		// ��ȡһ�������
		FileOutputStream fs = new FileOutputStream(file, true);
		// 1����ȡhttp����
		URL url = new URL(
				"https://data-jshop.jd.com/datalogPc?type=attention-heatmap&key=//sale.jd.com/act/8hJc2y6QSxX.html&y1=9636&y2=10212&duration=10001&juinfo=&sid=1213083052|1&maxHeight=12804");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		// 2����������ʽ
		http.setRequestMethod("GET");
		// 3���������룬���������Ȩ���������������õ�������Ĭ��Ϊtrue
		http.setDoInput(true);
		// 4����������ͷ��Ϣ
		http.setRequestProperty("Cookie", "_jda=122270672.1213083052.1511879122.1511879963.1511880394.3");
		// 5�����룬�������
		InputStream inputStream = http.getInputStream();
		// 6�����ֽ���ת��λ�ַ���
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

		// 7����ȡ������
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//
		String str = "";
		while ((str = bufferedReader.readLine()) != null) {
			// stringBuilder.append(str);
			fs.write(str.getBytes());
		}

		// �ͷ���Դ
		inputStream.close();

	}
}
