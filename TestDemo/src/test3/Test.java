package test3;

public class Test {
public static void main(String[] args) {
	 HuidiaoTest huidiao=new HuidiaoTest();  
     huidiao.setStudy(new StudyCallBack() {        
         @Override  
         public void studyMath(String bookname) {  
             System.out.println(bookname);  
         }  
     });  
}
}
