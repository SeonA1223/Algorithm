package Day210528;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//30분
public class Main_BOJ_1068_트리 {
	static int N, ans;
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int delNum = Integer.parseInt(br.readLine());
		boolean visited[] = new boolean[N];
		visited[delNum] = true;

		if (arr[delNum] == -1) {
			System.out.println("0");
			return;
		}
		// 노드 지우기
		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[i] == delNum) {
				removeNode(i, visited);
			}
		}

		// 리프노드 찾기
		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[i] == -1)
				dfs(i, visited);
		}
		
		System.out.println(ans);

	}

	private static void dfs(int i, boolean[] visited) {
		boolean checked = true;
		visited[i] = true;

		for (int j = 0; j < N; j++) {
			if (!visited[j] && arr[j] == i) {
				dfs(j, visited);
				checked = false;
			}
		}
		
		if(checked) ans++;
		
		

	}

	private static void removeNode(int nodeNum, boolean[] visited) {
		visited[nodeNum] = true;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && arr[i] == nodeNum) {
				removeNode(i, visited);
			}
		}

	}
}
