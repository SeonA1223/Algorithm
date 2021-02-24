package problem210224;

import java.util.Arrays;

public class GoodMorning {
	static int N = 3;
	static int R = 2;

	public static void main(String[] args) {

		String s[] = { "아침", "점심", "저녁" };

		System.out.println("순열");
		perm(s, 0, new boolean[N], new String[N]);
		System.out.println("조합");
		comb(s, 0, 0, new String[R]); // start=0, index=0;
		System.out.println("부분집합");
		subset(s, 0, new boolean[N]);

	}

	private static void subset(String[] s, int i, boolean[] bs) {
		if (i == N) {
			for (int j = 0; j < N; j++) {
				if (bs[j]) {
					System.out.print(s[j] + " ");
				}
			}
			System.out.println();
			return;
		}
		bs[i] = true;
		subset(s, i+1, bs);
		bs[i] = false;
		subset(s, i+1, bs);

	}

	private static void comb(String[] s, int start, int index, String[] value) {
		if (index == R) {
			System.out.println(Arrays.toString(value));
			return;
		}
		for (int i = start; i < N; i++) {
			value[index] = s[i];
			comb(s, i + 1, index + 1, value);
		}

	}

	private static void perm(String[] s, int i, boolean[] bs, String[] value) {
		if (i == N) {
			System.out.println(Arrays.toString(value));
			return;
		}
		for (int j = 0; j < N; j++) {
			if (bs[j])
				continue;
			bs[j] = true;
			value[i] = s[j];
			perm(s, i + 1, bs, value);
			bs[j] = false;
		}

	}

}
