package problem210222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size[][] = new int[101][101]; // 면적
		int N = Integer.parseInt(br.readLine()); // 색종이 갯수

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for (int j = x; j < x+width; j++) {
				for (int k = y; k < y+height; k++) {
					size[j][k] = i;
				}
			}
		}
		
		for (int t = 1; t <= N; t++) {
			int count = 0;
			for (int[] is : size) {
				for (int i : is) {
					if(i==t) count++;
				}
			}
			System.out.println(count);
			
		}

	}

}
