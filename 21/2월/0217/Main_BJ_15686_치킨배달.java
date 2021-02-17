package problem210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_15686_치킨배달 {
	static List<int[]> chickens, homes;
	static int minCityDistance = Integer.MAX_VALUE;
	 

	private static void comb(int M, int count, int start, int[][] arr) {
		if (count == M) {
			minCityDistance = Math.min(findCityDistance(arr), minCityDistance);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			arr[count][0] = chickens.get(i)[0];
			arr[count][1] = chickens.get(i)[1];
			comb(M, count + 1, i + 1, arr);
		}
	}
	
	private static int findCityDistance(int [][] arr) {
		int cityChickenDis =0;
		for (int i = 0; i < homes.size(); i++) { // 집을 기준으로
			int minDistance = 100;
			for (int j = 0; j < arr.length; j++) { // 치킨집들과 비교
				minDistance = Math.min(minDistance, Math.abs(homes.get(i)[0] - arr[j][0]) + Math.abs(homes.get(i)[1] - arr[j][1]));
			}
			cityChickenDis += minDistance;
		}
		return cityChickenDis;
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // N*N도시
		int M = Integer.parseInt(st.nextToken()); // 가장 수익을 많이 낼 수 있는 치킨집 갯수(폐업 안당함)

		chickens = new ArrayList<>();
		homes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1)
					homes.add(new int[] { i, j });
				else if (a == 2)
					chickens.add(new int[] { i, j });
			}
		}

		int[][] arr = new int[M][2];
		comb(M, 0, 0, arr);
		System.out.println(minCityDistance);

	}
}
