package test;

public class Outer {
	// 非静态内部类
	class Inner {
		public void test() {
			System.out.println("hello world");
			bar();
		}
	}

	// 静态方法
	public static void foo() {
		new Outer().new Inner().test();
	}

	public void bar() {
		System.out.println("你好");
	}

	/**
	 * 要在静态方法中调用内部类，则必须通过实例化获取一个外部类的对象，然后通过外部类的对象去调用内部类的实例化对象里面的方法。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Outer().new Inner().test();
		System.gc();// 垃圾回收的方法
		Runtime.getRuntime().gc();// 调用系统进行垃圾回收的方法
	}
}

class Demo {

}
