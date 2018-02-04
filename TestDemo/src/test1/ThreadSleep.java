package test1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

/**
 * 线程休眠
 * 
 * @author Administrator
 *
 */
public class ThreadSleep extends JFrame {

	private static final long serialVersionUID = 1L;
	private Thread t;// 定义一个线程变量
	// 定义颜色数组
	private static Color[] color = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.YELLOW,
			Color.PINK, Color.LIGHT_GRAY };
	// 创建随机对象
	private static final Random RANDOM = new Random();

	/**
	 * 定义获取颜色的方法
	 * 
	 * @return
	 */
	public static Color getColor() {
		// 随机产生一个color数组长度范围内的数字，以此为索引获取颜色
		return color[RANDOM.nextInt(color.length)];
	}

	public ThreadSleep() {
		t = new Thread(new Draw());// 获取线程对象
		t.start();// 开启线程
	}

	// 定义一个内部类，实现Runnable接口，用于在窗体中绘制线条
	class Draw implements Runnable {
		int x = 200;// 定义初始坐标
		int y = 50;

		@Override
		public void run() {// 重写run方法
			while (true) {// 无线循环
				try {
					// 设置线程休眠时间为100毫秒
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 获取组件绘图上下文对象
				Graphics graphics = getGraphics();
				// 设置绘图颜色
				graphics.setColor(getColor());
				// 绘制直线并等垂直坐标
				graphics.drawLine(x, y, 500, y += 4);
				if (y >= 500) {
					y = 50;// 将横向返回至初始位置
				}
			}

		}
	}

	/**
	 * 定义初始化程序界面的方法
	 */
	public static void init(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口，退出程序
		frame.setSize(width, height);// 设置窗体的宽和高
		frame.setVisible(true);// 使窗口可见
		frame.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		init(new ThreadSleep(), 400, 500);
	}

}
