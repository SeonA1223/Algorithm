package problem210318;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, cntA, cntB, min;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeCombination(0, new boolean[N], 0);
		System.out.println(min);
	}

	private static void makeCombination(int select, boolean[] selected, int startIdx) {
		if (startIdx == N / 2)
			return;

		if (select == N / 2) {
			cntA = cntB = 0;
			int[] A = new int[N/2];
			int[] B = new int[N/2];
			int idx1 = 0;
			int idx2 = 0;

			for (int i = 0; i < N; i++) {
				if (selected[i])
					A[idx1++] = i;
				else
					B[idx2++] = i;
			}
			System.out.println("A ; " + Arrays.toString(A));
			System.out.println("B ; " + Arrays.toString(B));

			for (int i = 0; i < N / 2 - 1; i++) {
				for (int j = i + 1; j < N / 2; j++) {
					cntA += arr[A[i]][A[j]];
					cntA += arr[A[j]][A[i]];
					cntB += arr[B[i]][B[j]];
					cntB += arr[B[j]][B[i]];
				}
			}

			min = Math.min(min, Math.abs(cntA - cntB));
			return;
		}

		for (int i = startIdx; i < N; i++) {
			selected[i] = true;
			makeCombination(select + 1, selected, i + 1);
			selected[i] = false;
		}
	}
}
