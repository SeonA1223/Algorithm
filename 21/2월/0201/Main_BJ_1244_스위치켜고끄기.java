package problem210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기 {
//	public static void print(int[] maps) {
//		for (int i = 1; i <= maps.length-1; i++) {
//			System.out.print(maps[i] + " ");
//		}
//		System.out.println();
//		System.out.println("---------------------");
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNumber = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] switches = new int[switchNumber+1];
		for (int i = 1; i <= switchNumber; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int students = Integer.parseInt(br.readLine());

		for (int i = 0; i < students; i++) {
			StringTokenizer in = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(in.nextToken());
			int aSwitch = Integer.parseInt(in.nextToken());

			switch (gender) {
			case 1://남자의 경우
				for (int j = aSwitch; j <= switchNumber; j++) {
					if (j % aSwitch == 0) {
						if (switches[j] == 0)
							switches[j] = 1;
						else
							switches[j] = 0;
					}
				}
//				print(switches);
				break;

			case 2: //여자 경우
				if (switches[aSwitch] == 0)//일단 자기의 값은 바꿔준다.
					switches[aSwitch] = 1;
				else
					switches[aSwitch] = 0;
				
				for (int k = 1; k <= (switchNumber - 1) / 2; k++) {
					int left = aSwitch - k;
					int right = aSwitch + k;
					if (left > 0 && left <= switchNumber && right > 0 && right <= switchNumber) {
						if (switches[left] == switches[right]) {
							if (switches[left] == 0) {
								switches[left] = 1;
								switches[right] = 1;
							} else {
								switches[left] = 0;
								switches[right] = 0;
							}
							continue;
						} else {
							break;
						}
					} else {
						break;
					}
				}
//				print(switches);
				break;
			}

		}
		for (int i = 1; i <= switchNumber; i++) {
			System.out.print(switches[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

}
