package test2;

public class Test3 {
	public static void main(String[] args) {
		// main(null);
		int test = new Test3().test();
		System.out.println(test);
		
	}

	@SuppressWarnings("finally")
	public int test() {
		int i = 10;
		try {
			int j=i/1;
			System.out.println(j);
			return j;
		} 
		catch(Exception e){
			System.out.println("“Ï≥£");
		}finally {
			return 200;
		}
	}
}
