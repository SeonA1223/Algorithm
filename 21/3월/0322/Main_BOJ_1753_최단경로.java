//package problem210322;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_BOJ_1753_최단경로 {
//
//	static class Node {
//		int vertex;
//		int value;
//		Node next;
//
//		public Node(int vertex, int value, Node next) {
//			super();
//			this.vertex = vertex;
//			this.value = value;
//			this.next = next;
//		}
//
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		Queue<Node> q = new LinkedList<>();
//		final int INF = Integer.MAX_VALUE;
//
//		st = new StringTokenizer(br.readLine(), " ");
//		int V = Integer.parseInt(st.nextToken());
//		int E = Integer.parseInt(st.nextToken());
//
//		Node[] list = new Node[V+1]; // 인접리스트 사용
//		int[] distance = new int[V+1]; // 시작정점에서의 거리 배열
//		boolean[] visited = new boolean[V+1]; // 방문체크
//
//		int start = Integer.parseInt(br.readLine());
//
//		for (int i = 0; i < E; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			list[u] = new Node(v, w, list[u]);
//		}
//
//		Arrays.fill(distance, INF);
//		distance[start] = 0;
//		
//		q.add(list[start]);
//		
//		while(!q.isEmpty()) {
//			Node node = q.poll();
//			visited[node.value] = true;
//			
//			for(Node temp = node; temp != null; temp = temp.next) {
//				if(!visited[temp.vertex] &&  distance[temp.vertex] > min + temp.value) {
//					distance[temp.vertex] = min + temp.value;
//				}
//			}
//		}
//		
//		for (int i = 1; i <= V; i++) {
//			if(distance[i] == INF) {
//				System.out.println("INF");
//			}else {
//				System.out.println(distance[i]);
//			}
//		}
//		
//		
//
//	}
//}
