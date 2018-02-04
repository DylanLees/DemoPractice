package test;

public class ProgramThree {
	public static void main(String[] args) {

		// String str = getStrAsBytes("人ABC", 3);
		String str = getStrAsBytes("人ABC们DE", 6);
		System.out.println(str);
	}

	private static String getStrAsBytes(String src, int Cutlen) {
		// 将输入的字符串转换为字节数组
		byte[] strBytes = src.getBytes();
		// 待截取的字节长度
		int rlen = 0;
		// 用于标识汉字默认未false
		boolean chineseFlag = false;
		// 获取字节数组的长度
		int srcLen = strBytes.length;
		// 判断需要截取的字节长度是否超出输入字符串的长度
		if (Cutlen > srcLen) {
			// 如果带截取的字节长度大于输入字符串的长度输出下面语句
			System.out.println("you want more than the source");
		} else {
			for (int i = 0; i < Cutlen; i++) {

				if (strBytes[i] > 0 && strBytes[i] < 256) {
					rlen++;
				} else {
					if (chineseFlag) {
						rlen++;// 不是汉字，待截取的字节长度+1
						chineseFlag = false;// 然后将汉字标志ChineseFlag设置为false
					} else {
						chineseFlag = true;// 是汉字则直接返回true，待截取的字节长度不需要加1
					}
				}
			}
		}
		return src.substring(0, rlen);// 通过字符串自带的substring方法截取字符串，并返回。
	}
}
