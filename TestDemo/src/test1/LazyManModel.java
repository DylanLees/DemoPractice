package test1;

/**
 * 懒汉式单例模式
 * 
 * @author Administrator
 *
 */
public class LazyManModel {
	private LazyManModel() {

	}

	private static LazyManModel lazyManModel = null;

	public LazyManModel getInstance() {
		if (lazyManModel == null) {
			
			lazyManModel = new LazyManModel();
		}
		return lazyManModel;
	}
}
