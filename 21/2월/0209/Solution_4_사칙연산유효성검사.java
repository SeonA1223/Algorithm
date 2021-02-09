package problem210209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 고려해야할 것!
 * 단말노드가 아닐경우 : 연산자("+-/*")만 와야함
 * 단말노드일경우 : 숫자만 와야함
 * contains() 메소드 사용 조심
 * exTree[1].contains(operation) // 작동 안함(왼 범위가 오범위보다 훨 커야함)
 * operation.contains(exTree[1]) // 작동함
 * */

public class Solution_4_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String operation = "+-/*";

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String exTree[];
			int result = 1;

			for (int i = 0; i < N; i++) {
				exTree = br.readLine().split(" ");
				if (exTree.length>2) { // 비단말노드
					if (!operation.contains(exTree[1]))
						result = 0;
				} else { // 단말노드
					if (operation.contains(exTree[1]))
						result = 0;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}

}
