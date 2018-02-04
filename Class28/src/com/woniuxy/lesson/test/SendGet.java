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
 * 模拟发送请求
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
	 * 定义发送请求的方法 利用java.net
	 * 
	 * @throws MalformedURLException
	 */
	public void sendGet() throws Exception {
		// 创建一个StringBuilder
		// StringBuilder stringBuilder = new StringBuilder();
		// 创建一个文件对象
		File file = new File("g:/jdmall.txt");
		// 获取一个输出流
		FileOutputStream fs = new FileOutputStream(file, true);
		// 1、获取http对象
		URL url = new URL(
				"https://data-jshop.jd.com/datalogPc?type=attention-heatmap&key=//sale.jd.com/act/8hJc2y6QSxX.html&y1=9636&y2=10212&duration=10001&juinfo=&sid=1213083052|1&maxHeight=12804");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		// 2、设置请求方式
		http.setRequestMethod("GET");
		// 3、设置输入，输出流及其权限输入流经常被用到，所有默认为true
		http.setDoInput(true);
		// 4、设置请求头信息
		http.setRequestProperty("Cookie", "_jda=122270672.1213083052.1511879122.1511879963.1511880394.3");
		// 5、输入，输出数据
		InputStream inputStream = http.getInputStream();
		// 6、将字节流转换位字符流
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

		// 7、获取缓存流
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		//
		String str = "";
		while ((str = bufferedReader.readLine()) != null) {
			// stringBuilder.append(str);
			fs.write(str.getBytes());
		}

		// 释放资源
		inputStream.close();

	}
}
