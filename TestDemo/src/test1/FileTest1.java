package test1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest1 {
	/*
	 * 创建文件的三种方式 1、File(String pathname) 2、File(String parent,String child)
	 * 3、File(File f,String child)
	 */
	public static void main(String[] args) {
//		File file = new File("G:/test.txt");// 方式一
//		File file = new File("G:/", "letter.txt");// 方式二,第一个字符串代表文件路径，第二个字符串代表文件名
		File file = new File("G:/", "digit");// 方式三
		if (!file.exists()) {// 文件不存在，执行的语句块
			System.out.println("文件不存在，正在创建...");
			try {
				file.createNewFile();// 文件不存在，创建新的文件
				System.out.println("文件创建成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("文件已经存在");
			if (file.isFile() && file.canRead()) {// 该文件是一个标准文件并且可读
				System.out.println("文件可读，正在读取文件信息...");
				String fileName = file.getName();// 获取文件名
				String filePath = file.getAbsolutePath();// 获取文件绝对路径
				long lastModifiedTime = file.lastModified();// 获取文件最后修改时间,返回的时间是毫秒
				boolean hidden = file.isHidden();// 获取该文件是否可读
				long len = file.length();// 获取该文件中的字节数
				// 创建simpleDateFormate对象，用于指定时间格式
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
				// 使用文件最后修改时间创建一个Date对象
				Date date = new Date(lastModifiedTime);
				// 格式化修改后的时间
				String time = sdf.format(date);
				System.out.println("fileName\t" + fileName);
				System.out.println("filePath\t" + filePath);
				System.out.println("lastModifiedTime\t" + lastModifiedTime+"ms");
				System.out.println("hidden\t" + hidden);
				System.out.println("len\t" + len);
				System.out.println("time\t" + time);
				// 删除文件
				file.delete();
				System.out.println("该文件的使命已经完成，已经被删除");

			} else {
				System.out.println("文件不可读");
			}
		}

	}
}
