package problem210210;

import java.util.Arrays;

public class Recursive {
	private static void recursive(int n) {
		if (n == 5)
			return;
		System.out.print(n + " ");
		recursive(n + 1);

	}

	private static void recursive1(int[] arr, int n) {
		if (n == arr.length)
			return;
		System.out.print(arr[n] + " ");
		recursive1(arr, n + 1);

	}

	private static void recursive2(int[] arr, int n, int result) {
		if (n == arr.length) {
			System.out.println("result= " + result);
			return;
		}

		recursive2(arr, n + 1, result + arr[n]);

	}

	private static void recursive3(int[] arr, int n, int result) {
		if (n == arr.length) {
			System.out.println("result= " + result);
			return;
		}

		recursive3(arr, n + 1, result * arr[n]);

	}

	private static void subset(int[] arr1, boolean[] isSelect, int count) {
		if (count == arr1.length) {
			for (int i = 0; i < count; i++) {
				if (isSelect[i] == true)
					System.out.print(arr1[i] + " ");
			}
			System.out.println();
			return;
		}
		isSelect[count] = true;
		subset(arr1, isSelect, count + 1);
		isSelect[count] = false;
		subset(arr1, isSelect, count + 1);

	}

	private static void combination(int[] arr1, int i, int count, int[] result) {
		if (count == 2) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int j = i; j < arr1.length; ++j) {
			result[count] = arr1[j];
			combination(arr1, i + 1, count + 1, result);
		}

	}

	private static void permutation(int[] arr1, boolean[] isSelect, int i, int[] result) {
		if (i == arr1.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int j = 0; j < arr1.length; j++) {
			if (isSelect[j] == true)
				continue;
			result[i] = arr1[j];
			isSelect[j] = true;
			permutation(arr1, isSelect, i + 1, result);
			isSelect[j] = false;
		}

	}

	public static void main(String[] args) {
		System.out.println("for문 사용");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("while문 사용");

		int i = 0;
		while (i < 5) {
			System.out.print(i + " ");
			i++;
		}

		System.out.println();
		System.out.println("재귀 사용");
		int n = 0;
		recursive(n);

		System.out.println();
		System.out.println("재귀1 사용");
		int[] arr = { 1, 3, 5, 7, 9 };
		recursive1(arr, 0);

		System.out.println();
		System.out.println("재귀2 사용해서 계산");
		recursive2(arr, 0, 0);

		System.out.println();
		System.out.println("재귀3 사용해서 계산");
		recursive3(arr, 0, 1);

		System.out.println();
		System.out.println("순열");
		int[] arr1 = { 1, 3, 5 };
		boolean[] isSelect = new boolean[arr1.length];
		int[] result = new int[arr1.length];
		permutation(arr1, isSelect, 0, result);

		System.out.println();
		System.out.println("조합");
		int[] result1 = new int[2];
		combination(arr1, 0, 0, result1);

		System.out.println();
		System.out.println("부분집합");
		subset(arr1, isSelect, 0);
	}
}
