package test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
	public static void main(String[] args) {
		// 序列化后生成指定文件路径
		File file = new File("G:" + File.separator + "person.ser");
		ObjectOutputStream oos = null;
		try {
			// 创建一个对象输出流
			oos = new ObjectOutputStream(new FileOutputStream(file));
			// 实例化Person类
			Person per = new Person("张三", 25);
			oos.writeObject(per);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
