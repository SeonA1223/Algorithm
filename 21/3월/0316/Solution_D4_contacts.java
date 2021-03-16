package problem210316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_contacts {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<ArrayList<Integer>> linkedlist;

		for (int tc = 1; tc <= 10; tc++) {
			linkedlist = new LinkedList<>();
			
			for (int i = 0; i <= 100; i++) {
				linkedlist.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				linkedlist.get(from).add(to);
			}
			



		}

	}

}
