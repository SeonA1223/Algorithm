package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4698_테네스의특별한소수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		boolean arr[] = new boolean[1000001]; // 처음엔 모든 수가 소수인것으로 초기화(false)
		arr[0] = true;
		arr[1] = true;

		for (int i = 2; i < Math.sqrt((double) 1000000) + 1; i++) {
			if (arr[i] == false) {
				int j = 2;
				while (i * j <= 1000000) {
					arr[i * j] = true;
					j += 1;
				}
			}

		} // 소수 거름

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int count = 0;

			for (int i = A; i <= B; i++) {
				if (arr[i] == false) { // 해당인덱스가 소수이면,
					String s = Integer.toString(i);
					if (s.contains(D))
						count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());

	}

}
