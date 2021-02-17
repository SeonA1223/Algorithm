package problem210217;

import java.util.Scanner;

/*
 * 2^n * 2*n (n이 10만 되도 10억 * 10억 만큼의 메모리를 차지하기 때문에 배열을 만들면 메모리 초과가 발생)
 * 따라서 4사분면으로 계속 나누면서 r,c의 위치가 어디에 있는지 확인해서 그 값을 판단하는 것이 중요
 */
public class Main_BJ_1074_z {

	private static void findLoc(int visit, int r, int c, int N) {
		if (N == 0) {
			System.out.println(visit);
			return;
		}
		int value = (int) Math.pow(2, N);
		int size = value * value;
		int midSize = value / 2;

		if (r < midSize && c < midSize) { // 1사분면
			findLoc(visit, r, c, N - 1);
		} else if (r < midSize && c >= midSize) { // 2사분면
			visit += size / 4;
			findLoc(visit, r, c - midSize, N - 1);
		} else if (r >= midSize && c < midSize) {
			visit += (size / 4) * 2;
			findLoc(visit, r - midSize, c, N - 1);
		} else if (r >= midSize && c >= midSize) {
			visit += (size / 4) * 3;
			findLoc(visit, r - midSize, c - midSize, N - 1);
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int r = scan.nextInt();
		int c = scan.nextInt();
		int visit = 0;

		findLoc(visit, r, c, N);

		scan.close();
	}

}
