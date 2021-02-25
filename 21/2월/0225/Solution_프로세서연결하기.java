package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_프로세서연결하기 {

//	static int dx[] = { 0, 1, 0, -1 };
//	static int dy[] = { 1, 0, -1, 0 };
	static int processor[][];

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private int[][] copyArray(int[][] arr) { // array복사
		int[][] copy = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				copy[i][j] = arr[i][j];
			}
		}

		return copy;
	}
	
	static class Node {
		int x,y;
		boolean[] check;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			check = new boolean[4];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();

		int T = stoi(br.readLine().trim());
		int cpuCount;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = stoi(br.readLine());
			cpuCount = 0;
			processor = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int value = stoi(st.nextToken());
					if (value == 1) {
						q.add(new Node(i, j));
						cpuCount++;
					}
					processor[i][j] = value;
				}
			}
			
			int m = N/2;
			int check[][] = new int[cpuCount][4];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (processor[i][j] == 1) {
						

					}
				}
			}
		}

	}

}
