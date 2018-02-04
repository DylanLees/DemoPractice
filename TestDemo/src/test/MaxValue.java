package test;

public class MaxValue {
	public static void main(String[] args) {
		int n = 10;
		int x = 0;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i < n && j < n && x < n && a[i] + a[j] == a[x]) {
					int temp=0;
					a[temp] = a[i] > a[j] ? a[i] : a[j];
					a[x]=a[temp];
				}
				System.out.println("最大值；"+a[x]);
			}
			System.out.println("最大值；"+a[x]);

		}
		System.out.println("最大值；"+a[x]);

	}
}
