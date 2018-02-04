package test1;

/**
 * 递归调用
 * 
 * @author Administrator
 *
 */
public class Recursion {
	/**
	 * 定义一个递归求阶乘的方法
	 */
	public static int getProduct(int src) {
		if (src <= 1) {
			return 1;
		} else {
			return src * getProduct(src - 1);// 递归即自己调用自己
		}
	}

	public static void main(String[] args) {
		int product = getProduct(6);
		System.out.println(product);
	}
}
