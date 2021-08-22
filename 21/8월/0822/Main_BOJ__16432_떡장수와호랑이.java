import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ__16432_떡장수와호랑이 {
	static int N;
	static int[] riceCake;
	static List<Integer>[] list;
	static boolean[][] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][10];
		riceCake = new int[N];
		list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
//
//		for (int i = 0; i < N; i++) {
//
//		}

		flag = false;
		// dfs 날짜 1 부터 시작, 전날에 먹는 떡 종류
		for (int num : list[0]) {
			riceCake[0] = num;
			dfs(1, num);
			if (flag)
				break;
		}

		if (flag) {
			for (int i = 0; i < N; i++) {
				System.out.println(riceCake[i]);
			}
		} else {
			System.out.println(-1);
		}

	}

	private static void dfs(int day, int ago) {
		if (flag)
			return;
		
		if (day >= N) {
			flag = true;
			return;
		}

		for (int num : list[day]) {
			if (num == ago || visited[day][num])
				continue;
			visited[day][num] = true;
			riceCake[day] = num;
			dfs(day + 1, num);
			if(flag) return;
		}
		
	}
}
