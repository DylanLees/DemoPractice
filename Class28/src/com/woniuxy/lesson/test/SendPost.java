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
	 * 1������java.net.URL����������Դ��URL���з�װ��������openConnection������ȡHttp����
	 * 2����������ʽ
	 * 3�������������������Ȩ��
	 * 4����������ͷ��Ϣ
	 * 5�������������
	 * 6���ͷ���Դ
	 */
	public static void main(String[] args) {
		//1������java.net.URL����������Դ��URL���з�װ��������openConnection������ȡHttp����
		try {
			URL url = new URL("http://localhost/Agileone_1.2/index.php/common/login");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			
//			2����������ʽ
			http.setRequestMethod("POST");
//			3�������������������Ȩ��
			http.setDoInput(true);
			http.setDoOutput(true);
//			4����������ͷ��Ϣ
			http.setRequestProperty("Cookie", "PHPSESSID=743fb7d2252bee6aa48b2ade3b592073");
			
//			5�������������
			//�������������������
			OutputStream os = http.getOutputStream();
			os.write("username=admin&password=admin&savelogin=true".getBytes());
			
			//��ȡ��������Ӧ����
			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(),"UTF-8"));
			String str = "";
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			//6���ͷ���Դ
			os.close();
			br.close();
			http.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
