package problem210202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	
//	private static int findMax(int[] boxes) {
//		int max = boxes[0];
//		int index = 0;
//		for(int i=1; i<boxes.length; i++) {
//			if(max < boxes[i]) {
//				max = boxes[i];
//				index = i;
//			}
//		}
//		return index;
//	}
//	private static int findMin(int[] boxes) {
//		int min = boxes[0];
//		int index = 0;
//		for(int i=1; i<boxes.length; i++) {
//			if(min > boxes[i]) {
//				min = boxes[i];
//				index = i;
//			}
//		}
//		return index;
//	}
	
	public static void main(String args[]) throws Exception {
		final int BOX_NUMBER = 100;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] boxes = new int[BOX_NUMBER];
			for (int i = 0; i < BOX_NUMBER; i++) { //박스들에 박스 갯수 넣기 
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < count; i++) {
				Arrays.sort(boxes);
				
				boxes[99] -= 1;
				boxes[0] += 1;
			}
			Arrays.sort(boxes);
			int result = boxes[99] - boxes[0];
			System.out.println("#"+ test_case + " " + result);
			
		}
	}
}