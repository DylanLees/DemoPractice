package test1;

import java.io.File;

public class FolderTest {
	public static void main(String[] args) {
		String path = "G:\\test";// 声明文件夹test所在的目录
		for (int i = 1; i <= 10; i++) {// 循环获取i，并用i命名新的文件夹
			File folder = new File(path + "\\" + i); // 根据新的目录创建file对象
			if (!folder.exists()) {// 文件夹不存在
				folder.mkdirs();// 创建新的文件夹，包括不存在的父类文件夹
			}
		}
		System.out.println("文件夹创建成功");
		File file = new File("G:\\");// 根据路径名，创建file对象
		File[] files = file.listFiles();// 获取G盘中所有文件和文件夹
		for (File folder : files) {
			if (folder.isFile()) {// 判断是否为文件
				System.out.println(folder.getName() + "文件");// 输出G盘下所有的文件
			} else if (folder.isDirectory()) {// 判断是否为文件夹
				System.out.println(folder.getName() + "文件夹");// 输出G盘下所有的文件夹
			}

		}

	}
}
