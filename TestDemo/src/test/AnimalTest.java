package test;

public class AnimalTest {
	public static void main(String[] args) {
		Animal animal = new Cat();// 向上转型
		animal.eat();
		Cat c = (Cat) animal;
		System.out.println("****************");
		animal = new Dog();// 向上转型
		animal.eat();
		Dog d = (Dog) animal;// 向下转型，需要强转。
		d.run();

	}
}
