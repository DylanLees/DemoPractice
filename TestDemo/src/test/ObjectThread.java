package test;

/**
 * 该线程类用于启动同步方法
 * 
 * @author Administrator
 *
 */
public class ObjectThread extends Thread {
	LockTestClass lock;
	int i = 0;

	public ObjectThread(LockTestClass lock, int i) {
		this.lock = lock;
		this.i = i;
	}

	/**
	 * 测试类锁和对象锁
	 */
	public void run3() {
		// 无锁方法
		// lock.noSynMethod(this.getId(),this);
		// 对象锁方法1，采用synchronized synInMethod的方式
		lock.synInMethod();
		// 对象锁方法2，采用synchronized(this)的方式
		// lock.synOnMethod();
		// 私有锁方法，采用synchronized(object)的方式
		// lock.synMethodWithObj();
		// 类锁方法，采用static synchronized increment的方式
		LockTestClass.increament();
	}

	/**
	 * 私有锁和对象锁
	 */
	public void run() {
		// 无锁方法
		// lock.noSynMethod(this.getId(),this);
		// 对象锁方法1，采用synchronized synInMethod的方式
		lock.synInMethod();
		// 对象锁方法2，采用synchronized(this)的方式
		// lock.synOnMethod();
		// 私有锁方法，采用synchronized(object)的方式
		lock.synMethodWithObj();
		// 类锁方法，采用static synchronized increment的方式
		// LockTestClass.increament();
	}

	/**
	 * 类锁和对象锁
	 */
	public void run2() {
		// 无锁方法
		// lock.noSynMethod(this.getId(),this);
		// 对象锁方法1，采用synchronized synInMethod的方式
		lock.synInMethod();
		// 对象锁方法2，采用synchronized(this)的方式
		lock.synOnMethod();
		// 私有锁方法，采用synchronized(object)的方式
		// lock.synMethodWithObj();
		// 类锁方法，采用static synchronized increment的方式
		// LockTestClass.increament();
	}
}
