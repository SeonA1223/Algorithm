package problem210209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paperNum = Integer.parseInt(br.readLine());
		int whitePaper[][] = new int[101][101];
		int result = 0;

		for (int i = 0; i < paperNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < 10 + x; j++) {
				for (int k = y; k < 10 + y; k++) {
					if (whitePaper[j][k] == 1)
						continue;
					whitePaper[j][k] = 1;
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
