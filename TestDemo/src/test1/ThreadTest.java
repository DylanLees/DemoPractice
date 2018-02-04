
package test1;

public class ThreadTest extends Thread {
	//定义一个变量记录次数
	int count=10;
	//重新线程的run方法
	@Override
	public void run() {
		while(true){
			System.out.print(count+" ");//打印输出次数
			if(--count==0){
				break;
			}
		}
	}
	public static void main(String[] args) {
		ThreadTest threadTest = new ThreadTest();
		//开启线程
		threadTest.start();
	}
}
