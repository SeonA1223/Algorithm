package problem210324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int islandNum = Integer.parseInt(br.readLine());

			int[][] arr = new int[islandNum][2];
			boolean[] visited = new boolean[islandNum];
			double[] minEdge = new double[islandNum];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < islandNum; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < islandNum; i++) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					} else {
						return o1[0] - o2[0];
					}
				}

			});
			Arrays.fill(minEdge, 987654321);
			minEdge[0] = 0;

			for (int i = 0; i < islandNum; i++) {
				double min = 987654321;
				int minVertex = 0;

				for (int c = 0; c < islandNum; c++) {
					if (!visited[c] && min > minEdge[c]) {
						min = minEdge[c];
						minVertex = c;
					}
				}

				visited[minVertex] = true;

				for (int j = 0; j < islandNum; j++) {
					if (!visited[j]) {
						double value = Math.sqrt(Math.pow(arr[minVertex][0] - arr[j][0],2) + Math.pow(arr[minVertex][1] - arr[j][1], 2));
						if(minEdge[j] > value) {
							minEdge[j] = value;
						}
					}
				}
			}
			
			double E = Double.parseDouble(br.readLine());
			double result = 0;
			for (int i = 0; i < islandNum; i++) {
				double value = E * Math.pow(minEdge[i], 2);
				result += value;
			}
			sb.append(Math.round(result)).append("\n");

		}
		System.out.println(sb.toString());
	}

}
