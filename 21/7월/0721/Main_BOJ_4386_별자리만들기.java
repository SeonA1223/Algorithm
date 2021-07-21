package Day210721;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_4386_별자리만들기 {
	static int N;
	static class Node {
		double x,y;
		
		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	
	}
	
	static Node[] nodes;
	static double[][] adjMatrix;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nodes = new Node[N];
		adjMatrix = new double[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			nodes[i] = new Node(x, y);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				double temp = getDis(nodes[i], nodes[j]);
				adjMatrix[i][j] = temp;
				adjMatrix[j][i] = temp;
			}
		}
		
		//prim 알고리즘 사용
		double[] distance = new double[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(distance, Double.MAX_VALUE);
		int start = 0;
		distance[start] = 0;
		
		int min_i = 0;
		double min = 0.0;
		double sum = 0.0;
		
		for(int i=0; i<N; i++) {
			min = Double.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min > distance[j]) {
					min_i = j;
					min = distance[j];
				}
			}
			
			visited[min_i] = true;
			sum += min;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && j != min_i &&
						distance[j] > adjMatrix[min_i][j]) {
					distance[j] = adjMatrix[min_i][j];
				}
			}
		}
		
		System.out.printf("%.2f", sum);
	}
	
	static double getDis(Node n1, Node n2) {
		return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
	}
}
