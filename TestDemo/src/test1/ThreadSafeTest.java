package test1;

/**
 * 模拟火车站购票系统功能
 * 
 * @author Administrator
 *
 */
public class ThreadSafeTest implements Runnable {// 实现Runnable接口
	int num = 10;// 设置当前票数

	@Override
	public void run() {// 重写run方法
		synchronized (this) {// 设置同步代码块
			while (true) {// 设置无线循环
				if (num > 0) {// 判断当前票数是否大于0
					try {
						// 使当前线程休眠100ms
						Thread.sleep(100);

					} catch (Exception e) {
						e.printStackTrace();
					}
					// 当前票数减1
					System.out.println("当前线程名称：" + Thread.currentThread().getName() + "剩余票数：" + num--);
				} else {
					System.out.println("对不起，票已经售罄");
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		ThreadSafeTest t = new ThreadSafeTest();// 实例化类对象
		Thread t1 = new Thread(t, "线程一");// 实例化四个线程
		Thread t2 = new Thread(t, "线程二");
		Thread t3 = new Thread(t, "线程三");
		Thread t4 = new Thread(t, "线程四");
		// 开启线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
