package Day210417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기본순열조합복습 {
	static int[] arr = {1,3,7};
	static List<Integer> A, B;


	public static void main(String[] args) {
		//4!해보기
		//순열
		int[] res = new int[arr.length];
		boolean[] visited = new boolean[arr.length];
//		perm(0, res, visited);
		
		//조합
		// 3C2
		int[] res2 = new int[2];
//		comb(0,0, res2);
//		comb2(0, 0, res2);
		
		//부분집합
		
		//부분집합을 사용했을 때
		boolean[] isSelected = new boolean[arr.length];
//		subset(0, isSelected);

		//조합을 사용했을 때
		List<Integer> list = new ArrayList<>();
//		subset2(0, list);
		
		//부분집합을 사용해 2개로 나누기
		int[] pair = new int[arr.length];
		A = new ArrayList<>();
		B = new ArrayList<>();
		subset3(0, pair);
	}

	private static void subset3(int cnt, int[] pair) {
		if(cnt == arr.length) {
			A.clear();
			B.clear();
					
			for (int i = 0; i < pair.length; i++) {
				if(pair[i] == 0) {
					A.add(arr[i]);
				}else {
					B.add(arr[i]);
				}
			}
			System.out.print("0출력 : ");
			for (int i : A) {
				System.out.print(i + " ");
			}
			System.out.print("1출력 : ");
			for (int i : B) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		pair[cnt] = 0;
		subset3(cnt+1, pair);
		pair[cnt] = 1;
		subset3(cnt+1, pair);
		
	}

	private static void subset2(int start, List<Integer> list) {
		for(int i : list) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = start; i < arr.length; i++) {
			list.add(arr[i]);
			subset2(i+1, list);
			list.remove(list.size()-1);
		}
		
	}

	private static void subset(int cnt, boolean[] isSelected) {
		if(cnt == isSelected.length) {
			for (int i = 0; i < isSelected.length; i++) {
				
					System.out.print(isSelected[i] ? arr[i] : "X");
				
			}
			System.out.println();
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1, isSelected);
		isSelected[cnt] = false;
		subset(cnt+1,isSelected);
		
	}

	private static void comb2(int cnt, int start, int[] res2) {
		if(cnt == res2.length) {
			System.out.println(Arrays.toString(res2));
			return;
		}
		
		if(start == arr.length) {
			return;
		}
		
		res2[cnt] = arr[start];
		
		//선택했을 때
		comb2(cnt+1, start+1, res2);
		
		//선택안했을 때
		comb2(cnt, start+1, res2);
		
	}

	private static void comb(int cnt, int start, int[] res2) {
		if(cnt == res2.length) {
			System.out.println(Arrays.toString(res2));
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			res2[cnt] = arr[i];
			comb(cnt+1, i+1, res2);
		}
		
	}

	private static void perm(int cnt, int[] res, boolean[] visited) {
		if(cnt == res.length) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for (int i = 0; i < res.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			res[cnt] = arr[i];
			perm(cnt+1, res, visited);
			visited[i] = false;
		}
		
	}

}
