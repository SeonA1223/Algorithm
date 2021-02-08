package problem210208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_3_암호문 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<String> arr = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			String[] original = br.readLine().split(" ");
			for (int i = 0; i < original.length; i++) {
				arr.add(original[i]);
			}
			int commandN = Integer.parseInt(br.readLine());
			String[] commands = br.readLine().split(" ");

			int c = 0;
			int index = 0;
			int count = 0;
			while (c < commands.length) {
				if (commands[c].equals("I")) {
					index = Integer.parseInt(commands[c + 1]);
					count = Integer.parseInt(commands[c + 2]);
					for (int i = index, j = 3, k = 0; k < count; i++, j++, k++) {
						arr.add(i, commands[c + j]);
					}

				}
				c = c + count + 3;
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();

		}
	}
}
