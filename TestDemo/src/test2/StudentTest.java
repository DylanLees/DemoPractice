package test2;

import java.util.Set;
import java.util.TreeSet;

public class StudentTest {
	public static void main(String[] args) {
		Set<Object> set = new TreeSet<Object>(); // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
		set.add(new Student("Hao LUO", 33));
		set.add(new Student("XJ WANG", 32));
		set.add(new Student("Bruce LEE", 60));
		set.add(new Student("Bob YANG", 22));

		for (Object stu : set) {
			System.out.println(stu);
		}
	}
}
