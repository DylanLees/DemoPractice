package test;

/**
 * 饿汉式单例模式
 * 
 * @author Administrator
 *
 */
public class SingletonTest {

	private SingletonTest() {

	}

	// 在类加载的时候，自动实例化
	private static final SingletonTest SINGLETON = new SingletonTest();

	public static SingletonTest getInstance() {

		return SINGLETON;
	}

}
