package test1;

public class ThreadSafeTest1 implements Runnable {
	int num = 10;// 默认票数

	/**
	 * 定义同步方法
	 */
	public synchronized boolean doit() {
		boolean soldout = false;// 默认未售罄
		if (num > 0) {
			try {
				// 设置线程休眠时间100ms
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "票数：" + num--);
		} else {
			System.out.println("对不起，票已经售罄");
			soldout = true;
		}
		return soldout;
	}

	@Override
	public void run() {
		while (true) {
			// 调用同步方法
			boolean doit = doit();
			if (doit) {
				break;
			}
		}

	}

	public static void main(String[] args) {
		ThreadSafeTest1 t = new ThreadSafeTest1();// 实例化类
		// 创建4个线程
		Thread t1 = new Thread(t, "线程1");
		Thread t2 = new Thread(t, "线程2");
		Thread t3 = new Thread(t, "线程3");
		Thread t4 = new Thread(t, "线程4");
		// 开启线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
