package problem210223;


import java.util.Scanner;

public class Main_BJ_2477_참외밭2 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int K = scann.nextInt();
		int[] length = new int[6];
		int bigWidth = 0;
		int bigHeight = 0;
		int smallWidth = 0;
		int smallHeight = 0;
		for (int i = 0; i < 6; i++) {
			scann.nextInt();
			length[i] = scann.nextInt();
		}

		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) { //짝수는 짝수끼리, 홀수는 홀수끼리
				if (bigWidth < length[i]) {
					bigWidth = length[i];
				}
			} else {
				if (bigHeight < length[i]) {
					bigHeight = length[i];
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (bigHeight == length[(i + 5) % 6] + length[(i + 1) % 6]) {
					smallWidth = length[i];
				}
			} else {
				if (bigWidth == length[(i + 5) % 6] + length[(i + 1) % 6]) {
					smallHeight = length[i];
				}
			}
		}
		int S = (bigWidth * bigHeight - smallWidth * smallHeight);
		System.out.println(S * K);

	}
}