package test2;

public class Student implements Comparable<Student> {
	private String name; // 姓名
	private int age; // 年龄

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int compareTo(Student o) {
		System.out.println(this.age);
		System.out.println(o.age);
		System.out.println(this.age - o.age);
		return o.age - this.age; // 比较年龄(年龄的升序)
	}

}
