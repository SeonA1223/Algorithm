package problem210715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14567_선수과목 {
	static int N, M;
	static List<Integer>[] list;
	static int[] year;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		year = new int[N + 1];
		Arrays.fill(year, 1);

		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			list[before].add(after);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				getMinSemester(i);
			}
		}
		
		for(int i=1; i<=N; i++) {
			sb.append(year[i]).append(" ");
		}
		System.out.println(sb.toString());

	}

	private static void getMinSemester(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		int temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			int now = year[temp];
			
			for(int i : list[temp]) {
				int next = now+1;
				if(year[i] < next) {
					year[i] = now+1;
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}
