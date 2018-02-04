package test;

/**
 * 懒汉式单例模式
 * 
 * @author Administrator
 *
 */
public class SingletonTest1 {
	private SingletonTest1() {

	}

	private static SingletonTest1 singleton1 = null;

	/**
	 * 第一次调用的时候实例化自己
	 * 
	 * @return
	 */
	public static SingletonTest1 getInstance() {
		if (singleton1 == null) {
			singleton1 = new SingletonTest1();
		}
		return singleton1;

	}

}
