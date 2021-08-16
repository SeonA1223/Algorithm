package problem210816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_BOJ_1744_수묶기 {
	static PriorityQueue<Integer> number;
	static PriorityQueue<Integer> negative;
	static boolean isZero;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		오름차순
		number = new PriorityQueue<>(Collections.reverseOrder());
		negative = new PriorityQueue<>();
		isZero = false;
		int res = 0;

		int N = Integer.parseInt(br.readLine());
		while (--N >= 0) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				isZero = true;
			else if (num < 0) {
				negative.add(num);
			} else {
				number.add(num);
			}
		}

		while (!negative.isEmpty()) {
			if (negative.size() >= 2) {
				int numA = negative.poll();
				int numB = negative.poll();

				res += numA * numB;
			} else {
				int temp = negative.poll();
				if (!isZero)
					res += temp;
			}
		}

		while (!number.isEmpty()) {
			if (number.size() >= 2) {
				int numA = number.poll();
				int numB = number.poll();

				if (numA == 1 || numB == 1) {
					res += numA + numB;
				} else {
					res += numA * numB;
				}
			} else {
				res += number.poll();
			}
		}

		System.out.println(res);

	}
}



