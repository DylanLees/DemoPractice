package test1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓存流测试 1、BufferedInputStream(缓存输入流) 2、BufferedOutputstream（缓存输出流）
 * 
 * @author Administrator
 *
 */
public class BufferedStreamTest {
	public static void main(String[] args) {
		// 创建一个字符串数组
		String content[] = { "你不喜欢我，", "我一点都不介意。", "因为我活下来，", "不是为了取悦你！" };
		File file = new File("G:/word.txt");
		if (!file.exists()) {// 文件不存在则创建文件
			try {
				System.out.println("文件不存在正在创建...");
				file.createNewFile();
				System.out.println("文件创建完成，正在写入...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("文件已经存在");
			FileOutputStream fos = null;// 创建FileOutputStream对象
			BufferedOutputStream bos = null;// 创建BufferedOutputStream对象
			FileInputStream fis = null;// 创建FileInputStream对象
			BufferedInputStream bis = null;// 创建BufferedInputStream对象
			try {
				// 实例化FileOutPutstream对象
				fos = new FileOutputStream(file);
				// 实例化BufferedOutputStream对象
				bos = new BufferedOutputStream(fos);
				// 创建一个字节数组用于存放需要写入文件的内容
				byte[] bcontent = new byte[1024];
				for (int i = 0; i < content.length; i++) {// 循环遍历字符串数组
					bcontent = content[i].getBytes();// 将遍历到的数组内容转换为字节数组
					bos.write(bcontent);// 将字节数组写入文件
				}
				System.out.println("写入成功！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 关闭流，释放资源
					bos.close();
					fos.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				fis = new FileInputStream(file);// 实例化FileInputStream对象
				bis = new BufferedInputStream(fis);// 实例化BufferedInputStream对象
				// 创建一个字节数组用于存放读取的信息
				byte[] bcontent = new byte[1024];
				// 将从文件中读取的信息存放到字节数组中
				int len = bis.read(bcontent);
				System.out.println("从word.txt中读取的内容是：" + new String(bcontent, 0, len));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 关闭流(先关闭缓存流，在关闭文件流)，释放资源
					bis.close();
					fis.close();
					file.delete();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
