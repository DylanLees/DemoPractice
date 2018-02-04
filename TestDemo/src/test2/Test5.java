package test2;

public class Test5 {
	public static void main(String[] args) {
		RecallTest recallTest = new RecallTest();
		// recallTest.setStudy(new ImplTest());
		recallTest.setStudy(new StudyCallBack() {
			// 匿名类的使用，new后面可以跟一个接口，也可以跟一个抽象类，然后通过匿名类的接口回调实现里面的方法

			@Override
			public void studyMath(String bookname) {
				System.out.println(bookname);

			}
		});
		// StudyCallBack implTest = new ImplTest();
		// recallTest.setStudy(implTest);
		try {
			Thread.sleep(100);//sleep()是线程Thread类的一个静态方法
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			recallTest.wait();//wait是Object类中的方法，所有的对象都可以去调用
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
