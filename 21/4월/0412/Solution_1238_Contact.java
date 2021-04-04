package Day210412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<Integer>[] arr;
		Queue<Integer> q;
		int visited[];
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			arr = new ArrayList[101];
			visited = new int[101]; //depth를 저장
			q = new LinkedList<>();
			
			int maxDepth = 0;

			for (int i = 0; i <= 100; i++) {
				arr[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i += 2) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				arr[from].add(to);
			}

			q.add(start);
			visited[start] = 0;

			//큐가 빈다는 것은 더 이상 연결된 정점이 없기 때문에 나온다.
			//따라서 마지막 깊이에 있는 노드들 중에서, 제일 큰 값을 찾으면 된다. 
			//동시에 노드가 정점이 없는 것이 아니기 때문에, 이미 전화가 끝나더라도,
			//다른 정점에서 전화를 할 수 있기 때문에, 마지막 깊이에서, 마지막으로 전화를 끊은 애들 중에서 제일 큰 값을 찾아야한다.
			while (!q.isEmpty()) { 
				int num = q.poll();
				maxDepth = visited[num];
				
				for (int a : arr[num]) {
					if (visited[a] == 0) {
						visited[a] = visited[num]+1;
							q.add(a);
					}
				}

			}
			int max = 0;
			for (int i = 1; i <= 100; i++) {
				if(visited[i] == maxDepth)
					max = Math.max(max, i);
			}
			
			
			sb.append(max).append("\n");

		}
		System.out.println(sb.toString());
	}
}
