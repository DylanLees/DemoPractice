package test2;

/**
 * 实现字符串的反转
 * 
 * @author Administrator
 *
 */
public class Test1 {
	public static void main(String[] args) {
		String reverse = reverse("123bad");
		System.out.println(reverse);
	}

	/**
	 * 定义一个静态反转字符串的方法
	 * 
	 * @param originStr
	 * @return
	 */
	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1) {// 字符串为空，或者小于等于1则直接返回该字符串
			return originStr;
		}
		System.out.println(originStr.substring(1));
		System.out.println(originStr.charAt(0));
		return reverse(originStr.substring(1)) + originStr.charAt(0);
		
	}
}
