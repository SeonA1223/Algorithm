import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_16562_친구비 {
	static int N, M, K, fee;
	static List<Integer>[] freinds;
	static int[] money;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		freinds = new ArrayList[N + 1];
		money = new int[N + 1];
		visited = new boolean[N + 1];
		fee = 0;

		for (int i = 0; i <= N; i++) {
			freinds[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			freinds[a].add(b);
			freinds[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				fee += makeFriends(i, money[i]);
			}
		}

//		boolean flag = true;
//		for (int i = 1; i <= N; i++) {
//			if (!visited[i]) {
//				flag = false;
//				break;
//			}
//		}

		if (fee > K) {
			System.out.println("Oh no");
		} else {
			System.out.println(fee);
		}

	}

	private static int makeFriends(int num, int minMoney) {
		visited[num] = true;

		int min = Math.min(money[num], minMoney);
		for (int i = 0; i < freinds[num].size(); i++) {
			int index = freinds[num].get(i);
			if (visited[index])
				continue;
			min = Math.min(min, makeFriends(index, min));
		}

		return min;

	}
}
