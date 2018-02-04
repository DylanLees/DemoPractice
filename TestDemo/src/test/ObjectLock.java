package test;

public class ObjectLock {
	public static void main(String[] args) {
		System.out.println("start time："+System.currentTimeMillis()+"ms");//输出当前系统时间
		 LockTestClass testClass = new LockTestClass();
		 for(int i=0;i<3;i++){
			 //实例化一个线程类对象
			 Thread thread = new ObjectThread(testClass,i);
			 thread.start();
		 }
	}

}
