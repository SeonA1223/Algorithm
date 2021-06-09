package Day210609;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10282_해킹2 {
	static class Node {
		int computerNum;
		int time;

		public Node(int computerNum, int time) {
			super();
			this.computerNum = computerNum;
			this.time = time;
		}

	}
	
	static List<Node>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (--T >= 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 갯수
			int d = Integer.parseInt(st.nextToken()); // 의존성 갯수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호
			
			list = new ArrayList[n+1];
			
			for (int i = 0; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list[b].add(new Node(a, s));
			}
			
			
			boolean[] visited = new boolean[n+1];
			int[] distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[c] = 0;

			int minTime;
			int minIndex = -1;

			for (int i = 1; i <=n; i++) {
				minTime = Integer.MAX_VALUE;
				
				for (int j = 1; j <=n; j++) {
					if(!visited[j] && minTime > distance[j]) {
						minTime = distance[j];
						minIndex = j;
					}
				}
				if(minTime == Integer.MAX_VALUE) {
					break;
				}
				visited[minIndex] = true;
				
				
				for(Node node : list[minIndex]) {
					if(!visited[node.computerNum] && distance[node.computerNum] > minTime + node.time) {
						distance[node.computerNum] = minTime + node.time;
					}
				}
			}

			int cnt = 0;
			int time = 0;
			for (int i = 1; i <=n; i++) {
				if(visited[i]) {
					cnt++;
					time = time < distance[i] ? distance[i] : time;
				}
			}
			sb.append(cnt).append(" ").append(time).append("\n");
		}
		System.out.println(sb.toString());
	}
}

