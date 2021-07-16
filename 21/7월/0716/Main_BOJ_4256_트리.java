package problem210716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4256_트리 {
	static int[] tree, preorder, inorder, indexArr;
	static int N;
	static Node nodes[];
	static boolean visited[];

	static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(br.readLine());
		while (--T >= 0) {
			N = Integer.parseInt(br.readLine());
			tree = new int[N + 1];
			preorder = new int[N + 1];
			inorder = new int[N + 1];
			nodes = new Node[N];
			visited = new boolean[N + 1];
			indexArr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
				for (int j = 1; j <= N; j++) {
					if (preorder[j] == inorder[i]) {
						indexArr[j] = i;
						break;
					}
				}
			}

			makeTree(1, 0, 1, N, 0);
		}
	}

	private static void makeTree(int index, int parent, int start, int end, int LR) {
		if(index > N) return;
		if(start >= end) return;
		
		int mid = preorder[index];
		if(visited[mid]) return;
		
		visited[mid] = true;
		nodes[index] = new Node(mid);
		int inorderIndex = indexArr[index];
		// 왼쪽
		
		makeTree(index+1, index, start, inorderIndex-1, -1);
		// 오른쪽
		makeTree(index + inorderIndex, index, inorderIndex+1, end, 1);

	}
}
