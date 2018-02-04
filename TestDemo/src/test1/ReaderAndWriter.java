package test1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * FileReader、FileWriter的使用
 * 
 * @author Administrator
 *
 */
public class ReaderAndWriter {
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {// 设置无限循环，实现控制台的多次输入
			try {
				// 在指定的磁盘中创建一个文本文件
				File file = new File("G:/word.txt");
				if (!file.exists()) {// 文件不存在则创建新文件
					System.out.println("文件不存在，正在创建中...");
					file.createNewFile();
				} else {
					System.out.println("文件已经找到，请输入你的操作选项：1、写入文件； 2、读取文件");
					// 获取输入的操作选项
					int option = SC.nextInt();
					switch (option) {
					case 1:// 在控制台输入1
							// 创建一个字符输出流，用于向指定的文件中写入数据
						FileWriter fw = null;
						System.out.println("请输入你要写入到文件中的内容");
						String wri = SC.next();
						try {
							fw = new FileWriter(file, true);
							fw.write(wri);// 将指定内容写入到文本中
							System.out.println("上述内容已经写到文件中");
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							fw.close();// 关闭输出流，释放资源
						}
						break;
					case 2:// 在控制台输入2
						FileReader fr = null;// 声明一个输入字符流，FileReader用于读取文件内容
						if (file.length() == 0) {
							System.out.println("文件中字符为0，文件中没有内容");
						} else {
							try {
								fr = new FileReader(file);// 创建用来读取指定文件内容的字符输入流
								// 创建一个可以容纳1024个字符的字符数组
								char[] cbuf = new char[1024];
								int hasread = -1;// 初始化已经读取到的字符数，-1表示文件中没有内容
								while ((hasread = fr.read(cbuf)) != -1) {
									// 将word.txt存放到字符数组中的内容转换位字符串读取出来
									System.out.println("文件word.txt的内容为：" + new String(cbuf, 0, hasread));
								}
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								fr.close();// 关闭字符输入流，释放资源
							}

						}
						break;

					default:
						System.out.println("格式输入错误，请输入数字！");
						break;
					}
				}

			} catch (Exception e) {
				System.out.println("文件格式输入不对，请重新输入");
			}

		}
	}

}
