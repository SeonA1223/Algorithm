package problem210219;

import java.util.Arrays;
import java.util.Scanner;

public class GoodMorning {
	static int N, R; // N:입력받을 데이터 수(전체데이터) R:선택할 데이터 수
	static int[] input, res; // input:입력데이터저장 res:결과데이터저장
	static boolean[] visited; // visited: 방문체크용 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		res = new int[R];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
//	      1. input배열에서 R개의 수를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("----- 순열 -----");
		makePermutation(0);

//	      2. input배열에서 R개의 수를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("----- 조합 -----");
		makeCombination(0, 0);

		visited = new boolean[N];
//	      3. input배열로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("----- 부분집합 -----");
		makeSubset(0);

		sc.close();

	}

	private static void makeSubset(int i) {
		
		if(i==N) {
			for (int j = 0; j < N; j++) {
				if(visited[j])
					System.out.print(res[j]);
			}
			System.out.println();
		}
		
		visited[i] = true;
		makeSubset(i+1);
		visited[i] = false;
		makeSubset(i+1);

	}

	private static void makeCombination(int i, int j) { // i = index j = start
		if (i == R) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for (int start = j; start < N; start++) {
			res[i] = input[start];
			makeCombination(i + 1, start + 1);
		}

	}

	private static void makePermutation(int i) {
		if (i == R) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for (int j = 0; j < N; j++) {
			if (visited[j])
				continue;
			res[i] = input[j];
			visited[j] = true;
			makePermutation(i + 1);
			visited[j] = false;

		}

	}

}
