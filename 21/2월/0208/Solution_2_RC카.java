package problem210208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2_RC카 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int distance = 0; //RC카가 간 거리
			int command = 0; //명령어
			int velocity = 0; //속도
			int seconds = Integer.parseInt(br.readLine());
			for (int i = 0; i < seconds; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				command = Integer.parseInt(st.nextToken());

				switch (command) {
				case 0: // 속도 그대로
					break;
				case 1: // 가속
					velocity = velocity + Integer.parseInt(st.nextToken());
					break;
				case 2: // 감속
					int result = velocity - Integer.parseInt(st.nextToken()); //현재 속도에서 감속할 경우
					velocity = result > 0 ? result : 0; 
					break;
				}
				distance += velocity;
			}
			bw.write("#" + t + " " + distance);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
