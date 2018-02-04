package com.woniuxy.lesson.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendPost {
	/*
	 * 1、利用java.net.URL类对请求的资源的URL进行封装，并利用openConnection方法获取Http对象
	 * 2、设置请求方式
	 * 3、设置输入输出及其它权限
	 * 4、设置请求头信息
	 * 5、输入输出数据
	 * 6、释放资源
	 */
	public static void main(String[] args) {
		//1、利用java.net.URL类对请求的资源的URL进行封装，并利用openConnection方法获取Http对象
		try {
			URL url = new URL("http://localhost/Agileone_1.2/index.php/common/login");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			
//			2、设置请求方式
			http.setRequestMethod("POST");
//			3、设置输入输出及其它权限
			http.setDoInput(true);
			http.setDoOutput(true);
//			4、设置请求头信息
			http.setRequestProperty("Cookie", "PHPSESSID=743fb7d2252bee6aa48b2ade3b592073");
			
//			5、输入输出数据
			//向服务器发送请求正文
			OutputStream os = http.getOutputStream();
			os.write("username=admin&password=admin&savelogin=true".getBytes());
			
			//获取服务器响应正文
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(),"UTF-8"));
			String str = "";
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			//6、释放资源
			os.close();
			br.close();
			http.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
