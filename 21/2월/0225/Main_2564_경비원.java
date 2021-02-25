package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_경비원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int sumDist = 0;
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int storeNum = Integer.parseInt(br.readLine());
		int stores[][] = new int[storeNum+1][2];

		for (int i = 0; i <= storeNum ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int direction = Integer.parseInt(st.nextToken());
			int far = Integer.parseInt(st.nextToken());

			stores[i][0] = direction;
			stores[i][1] = far;

		}
		int dsDistance = stores[storeNum][0];
		int dsFar = stores[storeNum][1];

		for (int j = 0; j < storeNum; j++) {
			int storeDis = stores[j][0];
			int storeFar = stores[j][1];

			switch (dsDistance) {
			case 1: // 북 x=0
				if (storeDis == 1) {
					sumDist += Math.abs(dsFar - storeFar);
					break;
				} else if (storeDis == 2) {
					int a = dsFar + c + storeFar;
					int b = r - dsFar + c + r - storeFar;
					sumDist += Math.min(a, b);
					break;
				} else if (storeDis == 3) {
					sumDist += dsFar + storeFar;
					break;
				} else if (storeDis == 4) {
					sumDist += (r - dsFar) + (c - storeFar);
					break;
				}
			case 2: // 남 x=r-1
				if (storeDis == 1) {
					int a = dsFar + c + storeFar;
					int b = r - dsFar + c + r - storeFar;
					sumDist += Math.min(a, b);
					break;
				} else if (storeDis == 2) {
					sumDist += Math.abs(dsFar - storeFar);
					break;
				} else if (storeDis == 3) {
					sumDist += dsFar + c - storeFar;
					break;
				} else if (storeDis == 4) {
					sumDist += r - dsFar + c - storeFar;
					break;
				}

			case 3:
				if (storeDis == 1) {
					sumDist += dsFar + storeFar;
					break;
				} else if (storeDis == 2) {
					sumDist += c - dsFar + storeFar;
					break;
				} else if (storeDis == 3) {
					sumDist += Math.abs(dsFar - storeFar);
					break;
				} else if (storeDis == 4) {
					int a = dsFar + r + storeFar;
					int b = c - dsFar + r + c - storeFar;
					sumDist += Math.min(a, b);
					break;
				}

			case 4:
				if (storeDis == 1) {
					sumDist += dsFar + r - storeFar;
					break;
				} else if (storeDis == 2) {
					sumDist += c -dsFar + r - storeFar;
					break;
				} else if (storeDis == 3) {
					int a = dsFar + r + storeFar;
					int b = c - dsFar + r + c - storeFar;
					sumDist += Math.min(a, b);
					break;
				} else if (storeDis == 4) {
					sumDist += Math.abs(dsFar - storeFar);
					break;
				}

			}

		}
		System.out.println(sumDist);

	}

}
