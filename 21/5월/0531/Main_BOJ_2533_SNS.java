package Day210531;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 자신이 얼리어답터 => 자신과 연결된 노드는 얼리어답터여도 되고, 아니여도 된다.
 * 자신이 얼리어답터X => 자신과 연결된 노드는 얼리어답터여야 한다.
 * 
 * dp[N+1][2]
 * dp[cur][0] = 0 : 얼리어답터가 아닐 때
 * dp[cur][1] = 1 : 얼리어답터일때
 * */
public class Main_BOJ_2533_SNS {
	static int N;
	static List<Integer> arr[];
	static int[][] dp;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		

		//어떤 노드를 잡아도, root 노드일 수 있으므로 임의의 Node번호를 지정하면 된다.
		dp(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void dp(int cur) {
		visited[cur] = true;
		dp[cur][0] = 0; // 얼리어답터가 아닐 때
		dp[cur][1] = 1; // 얼리어답터일때

		for (int vertex : arr[cur]) {
			if (!visited[vertex]) {
				dp(vertex);
				dp[cur][0] += dp[vertex][1];
				dp[cur][1] += Math.min(dp[vertex][0], dp[vertex][1]);
			}
		}

	}
}
