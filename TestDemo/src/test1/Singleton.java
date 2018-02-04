package test1;

/**
 * 饿汉式
 * 
 * @author Administrator
 *
 */
public class Singleton {

	private Singleton() {

	}

	// 类加载的时候就进行实例化
	private static final Singleton SINGLETON = new Singleton();

	public Singleton getInstance() {
		return SINGLETON;
	}
}
