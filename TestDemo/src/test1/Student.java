package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter、BufferedReader
 * 
 * @author Administrator
 *
 */
public class Student {
	public static void main(String[] args) {
		// 创建一个字符串数组
		String content[] = { "你不喜欢我，", "我一点都不介意。", "因为我活下来，", "不是为了取悦你！" };
		// 创建一个文件
		File file = new File("G:/word.txt");
		if (!file.exists()) {// 文件不存在则创建文件
			try {
				System.out.println("文件不存在正在创建文件中...");
				file.createNewFile();
				System.out.println("文件创建成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				FileWriter fw = new FileWriter(file);// 创建FileWriter对象
				BufferedWriter bufw = new BufferedWriter(fw);// 创建BufferedWriter对象
				for (int i = 0; i < content.length; i++) {// 循环遍历字符串数组的内容
					bufw.write(content[i]);// 将遍历出的内容写入到缓存流中
					bufw.newLine();// 将数组中的单个元素以单行的形式写入到文件中
				}
				bufw.close();// 关闭BufferedWriter流
				fw.close();// 关闭FileWriter流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileReader fr = new FileReader(file);// 创建FileReader对象
				BufferedReader bufr = new BufferedReader(fr);// 创建BufferedReader流
				// 创建一个字符串对象
				String s = null;
				int row = 0;// 声明统计行数的变量
				while ((s = bufr.readLine()) != null) {// 如果文件文本行数不为空就进入循环
					row++;
					System.out.println("第" + row + "行：" + s);
				}
				bufr.close();// 关闭BufferedReader流
				fr.close();// 关闭FileReader流

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}
