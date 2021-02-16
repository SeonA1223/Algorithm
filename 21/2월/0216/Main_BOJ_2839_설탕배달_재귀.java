package problem210216;

import java.util.Scanner;

public class Main_BOJ_2839_설탕배달_재귀 {
	static int N;

	private static void findNum(int weight, int cnt) {
		if (weight > N)
			return;
		if (weight == N) {
			System.out.println(cnt);
			System.exit(0);
		}
		findNum(weight + 5, cnt + 1); //5가 3보다 훨씬 크므로, 최대한 적은 봉지를 차지하기 위해서는 +5가 +3보다 더 빨리 와야한다.
		findNum(weight + 3, cnt + 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();

		findNum(0, 0);
		System.out.println("-1");
		scan.close();
	}

}
