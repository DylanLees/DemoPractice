package test;

/**
 * 懒汉式单例模式
 * 
 * @author Administrator
 *
 */
public class Singleton {
	private Singleton() {

	}
	//当要使用的时候，才进行实例化
	private static Singleton singleton = null;
	public static synchronized Singleton getInstance() {
		if (singleton == null) {
			new Singleton();
		}
		return singleton;
	}
}
