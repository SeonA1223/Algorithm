package Day210415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		int arr[] = new int[N + k];
		int count = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			arr[N + i] = arr[i];
		}

		HashSet<Integer> hashset = new HashSet<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < k; j++) {
				if (hashset.isEmpty()) {
					hashset.add(arr[i + j]);
				} else {
					hashset.add(arr[i + j]);
				}
			}

			if (hashset.contains(c))
				count = Math.max(count, hashset.size());
			else
				count = Math.max(count, hashset.size() + 1);
			hashset.clear();
		}

		System.out.println(count);

	}
}
