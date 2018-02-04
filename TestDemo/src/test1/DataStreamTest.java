package test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataInputStream、DataOutputStream
 * 
 * @author Administrator
 *
 */
public class DataStreamTest {
	public static void main(String[] args) {
		// 创建一个文件
		File file = new File("G:data.txt");
		if (!file.exists()) {// 文件不存在则创建一个文件
			try {
				System.out.println("文件不存在，正在创建...");
				file.createNewFile();
				System.out.println("文件创建完成");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		try {
			// 创建一个FileOutputStream对象
			FileOutputStream fos = new FileOutputStream(file);
			// 创建一个DataOutputStream对象
			DataOutputStream dos = new DataOutputStream(fos);
			try {
				dos.writeUTF("写入字符串");// 写入String型数据
				dos.writeInt(12);// 写入int型数据
				dos.writeLong(2689L);// 写入长整型数据
				dos.writeDouble(198.5);// 写入double型数据
				dos.writeFloat(125.1f);// 写入float型数据
				dos.writeBoolean(true);// 写入布尔型数据
				dos.close();// 关闭数据输出流DataOutputStream

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("文件已经存在，正在读取信息...");
		try {
			// 创建一个FileInputStream对象
			FileInputStream fis = new FileInputStream(file);
			// 创建一个DataInputStream对象
			DataInputStream dis = new DataInputStream(fis);
			System.out.println("读取UTF型数据：\t" + dis.readUTF());
			System.out.println("读取double型数据：\t" + dis.readDouble());
			System.out.println("读取float型数据：\t" + dis.readFloat());
			System.out.println("读取Long型数据：\t" + dis.readLong());
			System.out.println("读取int型数据：\t" + dis.readInt());
			System.out.println("读取boolean型数据：\t" + dis.readBoolean());
			dis.close();// 关闭数据读取流DataInputStream

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
