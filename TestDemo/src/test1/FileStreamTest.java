package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream和FileInputStream,字节流
 * 
 * @author Administrator
 *
 */
public class FileStreamTest {
	public static void main(String[] args) {
		// 创建一个文件对象
		File file = new File("G:/datas.txt");
		if (!file.exists()) {
			try {
				System.out.println("文件不存在，正在创建...");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("文件已经存在，正在向文件写入信息...");
		try {
			// 创建FileOutputStream对象，用于向文件中写入数据
			FileOutputStream fos = new FileOutputStream(file);
			// 定义一个字符串，即需要写入到指定文件中的内容
			String content = "你见过洛杉矶凌晨四点的样子吗？";
			byte[] bytes = content.getBytes();// 将字符串转换位字节数组
			fos.write(bytes);// 将字节数组写入到指定文件中
			fos.close();// 关闭输出流，释放资源
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			// 创建一个FileInputStream对象，读取指定文件的内容
			FileInputStream fis = new FileInputStream(file);
			// 创建一个字节数组，用于存储读取到的内容
			byte byt[] = new byte[1024];
			int len = fis.read(byt);// 从文件中读取信息，并存入到字节数组中去
			// 将文件中的信息在控制台输出
			System.out.println("文件中的信息是：" + new String(byt, 0, len));
			// 关闭输入流
			fis.close();// 释放资源
			file.delete();// 该文件使命已经完成,删除文件
			System.out.println("该文件使命已经完成,文件已删除!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
