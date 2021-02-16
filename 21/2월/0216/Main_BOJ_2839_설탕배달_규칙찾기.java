package problem210216;

import java.util.Scanner;

public class Main_BOJ_2839_설탕배달_규칙찾기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int count = 0;

		if (N == 4 || N == 7)
			count = -1;
		else if (N % 5 == 1 || N % 5 == 3)
			count = (N / 5) + 1;
		else if (N % 5 == 2 || N % 5 == 4)
			count = (N / 5) + 2;
		else if (N % 5 == 0)
			count = (N / 5);

		System.out.println(count);

	}
}
