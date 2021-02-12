package problem210212_보충;

import java.util.ArrayList;
import java.util.Arrays;

public class 조합복습 {
	/*
	 * 순열 순서X 중복X 각 수를 나열해놓은 것(3C3일경우 1,2,3 => 배열 그대로 출력하면 됨!)
	 */
	static int N = 4, R = 4, count;
	static String fruits[] = { "사과", "복숭아", "파인애플", "아이스크림" };
	static StringBuffer sb = new StringBuffer();

	private static void comb(int start) {

		count++;
		System.out.println(sb.toString());
		for (int i = start; i < N; i++) {
			sb.append(fruits[i]);
			comb(i + 1);
			sb.setLength(sb.length()-fruits[i].length());
		}

	}

	public static void main(String[] args) {
//		if (N == R)
//			System.out.println(Arrays.toString(fruits));
		comb(0);
		System.out.println(count);

	}

}
