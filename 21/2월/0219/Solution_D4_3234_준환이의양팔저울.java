package problem210219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울 {
	static int N, cases;
	static int weights[], order[];

	private static void subset(int[] order, int index, int leftWeight, int rightWeight) {
		if (leftWeight < rightWeight)
			return;

		if (index == N) {
			cases++;
			return;
		}
		
		subset(order, index+1, leftWeight+order[index], rightWeight);
		subset(order, index+1, leftWeight, rightWeight+order[index]);

	}

	private static void permutation(int index, boolean[] bs) {
		if (index == N) {
			subset(order, 0, 0, 0);
			return;
		}

		for (int j = 0; j < N; j++) {
			if (bs[j])
				continue;
			bs[j] = true;
			order[index] = weights[j];
			permutation(index + 1, bs);
			bs[j] = false;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			order = new int[N];
			cases = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}

			permutation(0, new boolean[N]);
			sb.append("#").append(tc).append(" ").append(cases).append("\n");
		}
		System.out.println(sb.toString());
	}

}

//	private static boolean putOnScalePossible(ArrayList<Integer> leftSide, ArrayList<Integer> rightSide, int leftSize,
//			int rightSize, int leftWeight, int rightWeight) {
//
//		if (leftWeight < rightWeight)
//			return false;
//
//		if (leftSize < 0 && rightSize < 0) {
//			return true;
//		}
//		if (leftSize < 0 || rightSize < 0) {
//			if (leftSize < 0)
//				leftSize = 0;
//			if(rightSize < 0)
//				rightSize = 0;
//		}
//
//		if (putOnScalePossible(leftSide, rightSide, leftSize - 1, rightSize - 1, leftWeight + leftSide.get(leftSize),
//				rightWeight + rightSide.get(rightSize))) {
//			return true;
//		}
//
//		return true;
//
//	}