package problem210815;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_1484_다이어트 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int G = sc.nextInt();

		int x = 2;
		int y = 1;
		List<Integer> list = new ArrayList<>();

		while (x > y) {
			long res = (x * x) - (y * y);

			if (res < G) {
				x++;
			} else if (res > G) {
				y++;
			} else {
				list.add(x);
				x++;
			}

		}

		if (list.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
