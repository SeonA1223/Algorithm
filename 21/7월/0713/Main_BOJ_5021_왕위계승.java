package problem210713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5021_왕위계승 {
	static List<List<String>> list;
	static Map<String, Integer> map;
	static int N, M;
	static String result;
	static int far;

	public static void main(String[] args) throws Exception {
		list = new ArrayList<>();
		map = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = "";
		far = Integer.MAX_VALUE;
		String start = br.readLine();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			for (int j = 0; j < 2; j++) {
				String parent = st.nextToken();
				if (!map.containsKey(parent)) {
					map.put(parent, cnt);
					list.add(new ArrayList<>());
					list.get(cnt).add(child);
					cnt++;
				} else {
					int index = map.get(parent);
					list.get(index).add(child);
				}
			}

			if(!map.containsKey(child)) {
				map.put(child, cnt);
				list.add(new ArrayList<>());
				cnt++;
			}
		}

		for (int i = 0; i < M; i++) {
			String person = br.readLine();
			topologicalSort(start, person);
		}
		
		System.out.println(result);

	}

	private static void topologicalSort(String start, String person) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int index = map.get(node.name);
			if(node.name.equals(person)) {
				if(node.time < far) {
					far = node.time;
					result = person;
				}
				return;
			}
			
			for(String p : list.get(index)) {
				q.add(new Node(p, node.time+1));
			}
		}

	}
	
	static class Node {
		String name;
		int time;
		public Node(String name, int time) {
			super();
			this.name = name;
			this.time = time;
		}
		
		
	}
}
