package test1;

import java.awt.Container;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SwingAndThread extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jl = new JLabel();// 声明JLabel对象
	private static Thread t;// 声明一个线程对象
	private int count = 0;// 声明计数变量
	private Container container = getContentPane();// 声明容器
	// 定义一个构造方法

	public SwingAndThread() {
		// 绝对定位窗体大小与位置
		setBounds(300, 200, 250, 100);
		// 使窗体不使用任何布局管理器
		container.setLayout(null);
		try {
			// 获取图片的url，此图片与本类在同一个包下
			URL url = SwingAndThread.class.getResource("1.png");
			// 实例化一个Icon
			ImageIcon icon = new ImageIcon(url);
			// 将图片防止在标签中
			jl.setIcon(icon);
		} catch (Exception e) {
			System.out.println("图片不存在，请将1.png的图片复制到当前目录下！");
			return;
		}
		// 将图片设置在标签的最左边
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		// 设置标签的位置与大小
		jl.setBounds(10, 10, 200, 50);
		jl.setOpaque(true);// 设置透明度为不透明
		Thread t = new Thread(new Roll());// 获取一个线程
		t.start();// 开启线程
		container.add(jl);// 将标签添加到容器中
		setVisible(true);// 设置窗体可见
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭窗口则退出程序

	}

	// 定义一个内部类，实现Runnable接口
	class Roll implements Runnable {

		@Override
		public void run() {
			while (count <= 200) {// 设置循环条件
				// 将标签横坐标用变量表示
				jl.setBounds(count, 10, 200, 50);
				try {
					// 为了体现进度条的移动效果，设置休眠时间为1000毫秒
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				count += 4;// 使横坐标每次增加4
				// 当图标达到最右边时使其回到标签的最左边
				if (count == 200) {
					count = 10;// 标签最左边的初始坐标值为10
				}
			}

		}
	}

	public static void main(String[] args) {
		new SwingAndThread();
	}

}
