package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			char[][] characters = new char[5][];

			int maxLength = 0;
			for (int i = 0; i < 5; i++) {
				characters[i] = br.readLine().toCharArray();
				if (maxLength < characters[i].length)
					maxLength = characters[i].length;
			}

			char[][] newChar = new char[5][maxLength];
			for (int i = 0; i < newChar.length; i++) {
				Arrays.fill(newChar[i], '0');
				
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < characters[i].length; j++) {
					if (characters[i][j] == '0') {
						newChar[i][j] = '^';
					} else {
						newChar[i][j] = characters[i][j];
					}
				}
			}

			for (int i = 0; i < maxLength; i++) {
				for (int j = 0; j < 5; j++) {
					char c = newChar[j][i];
					if (newChar[j][i] == '^')
						sb.append('0');
					else if(newChar[j][i] == '0')
						continue;
					else {
						sb.append(newChar[j][i]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
