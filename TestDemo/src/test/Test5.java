package test;

public class Test5 {
	 static{
	    	System.out.println("1");
	    }
	class A {

	    public A() {
	        System.out.print("2");
	    }
	    
	   
	}
	class B extends A{
	    public B() {
	        System.out.print("b");
	    }
	}
	 public static void main(String[] args) {
	        A ab = new Test5().new B();
	        ab = new Test5().new B();
	    }
}
