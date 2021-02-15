package problem210215;

import java.util.Scanner;

public class Main_boj_3040 {
	static final int FAKENUM = 9;
	static final int TRUENUM = 7;
	static int[] fPeople;
	static int[] sPeople;

	private static void comb(int start, int count, int sum) {
		if (sum > 100)
			return;
		if (count == TRUENUM) {
			if (sum == 100) {
				for (int s : sPeople) {
					System.out.println(s);
				}
			}
			return;
		}

		for (int i = start; i < FAKENUM; i++) {
			sPeople[count] = fPeople[i];
			comb(i + 1, count + 1, sum + fPeople[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fPeople = new int[FAKENUM];
		sPeople = new int[TRUENUM];

		for (int i = 0; i < FAKENUM; i++) {
			fPeople[i] = sc.nextInt();
		}

		comb(0, 0, 0);

	}

}
