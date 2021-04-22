package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_요리사_np {
	static int N, M, ans;
	static int res;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			M = N / 2;
			// 조합을 통해 2개로 나누기
			arr = new int[N][N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0, new boolean[N]);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void comb(int index, int start, boolean[] visited) {
		if (index == M) {
			int ai = 0;
			int bi = 0;
			int[] a = new int[M]; // 각각의 인덱스를 담는다
			int[] b = new int[M];

			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					a[ai] = i;
					ai++;
				} else {
					b[bi] = i;
					bi++;
				}
			}
			res = 0;
			int asum=0;
			synergy(a, 0, 0, new int[2]);
			asum = res;
			res = 0;
			synergy(b,0,0, new int[2]);
			int bsum = 0;
			bsum = res;
			ans = Math.min(ans, Math.abs(asum-bsum));
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			comb(index + 1, i+1, visited);
			visited[i] = false;
		}

	}

	private static void synergy(int[] a, int index, int start, int[] s) {
		if (index == 2) {
			res += arr[s[0]][s[1]] + arr[s[1]][s[0]];
			return;
		}
		if(start == M) return;	
		s[index] = a[start];
		synergy(a, index+1, start+1, s);
		synergy(a, index, start+1, s);
		

	}
//	private static void synergy(int[] a, int index, int start, int[] s) {
//		if (index == 2) {
//			res += arr[s[0]][s[1]] + arr[s[1]][s[0]];
//			return;
//		}
//		
//		for(int i=start; i<M; i++) {
//			s[index] = a[i];
//			synergy(a, index+1, i+1, s);
//		}
//		
//		
//		
//	}
}
