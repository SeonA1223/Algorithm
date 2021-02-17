package problem210217;

import java.util.Arrays;

public class GoodMorning {

	static int[] num = { 1, 2, 3, 4 };
	static int N = 2;
	static StringBuffer sb;
	static boolean[] isCheck;
	static int count;

	public static void main(String[] args) {
		sb = new StringBuffer();
		isCheck = new boolean[num.length];
		count = 0;

//      1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("----- 순열 -----");
		makePermutation(0, new int[N], new boolean[num.length]);
		System.out.println(count);

//      2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("----- 조합 -----");
		count = 0;
		makeCombination(0, new int[N], 0);
		System.out.println(count);

//      3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("----- 부분집합 -----");
		count = 0;
		makeSubset(0);
		System.out.println(count);
		
		System.out.println("----- 부분집합2 -----");
		count = 0;
		makeSubset2(0);
		System.out.println(count);

	}

	private static void makeSubset(int i) {
		System.out.println(sb.toString());
		count++;
		for (int j = i; j < num.length; j++) {
			sb.append(num[j]);
			makeSubset(j + 1);
			sb.setLength(sb.length() - 1);
		}

	}

	private static void makeSubset2(int i) {
		if (i == num.length) {
			count++;
			for (int j = 0; j < isCheck.length; j++) {
				if (isCheck[j]) {
					System.out.print(num[j]);
				}
			}
			System.out.println();
			return;
		}
		isCheck[i] = true;
		makeSubset2(i + 1);
		isCheck[i] = false;
		makeSubset2(i + 1);

	}

	private static void makeCombination(int i, int[] js, int j) { // i= count, j = start
		if (i == N) {
			count++;
			System.out.println(Arrays.toString(js));
			return;
		}
		for (int index = j; index < num.length; index++) {
			js[i] = num[index];
			makeCombination(i + 1, js, index + 1);
		}

	}

	private static void makePermutation(int i, int[] js, boolean[] bs) {
		if (i == N) {
			count++;
			System.out.println(Arrays.toString(js));
			return;
		}
		for (int j = 0; j < bs.length; j++) {
			if (bs[i])
				continue;
			bs[i] = true;
			js[i] = num[j];
			makePermutation(i + 1, js, bs);
			bs[i] = false;
		}

	}
}