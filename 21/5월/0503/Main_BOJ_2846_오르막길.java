package Day210503;

import java.util.Scanner;

public class Main_BOJ_2846_오르막길 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		int index = 1;
		int start = 0;
		int end = 0;
		int num = arr[start];
		int max = 0;
		
		while(true) {
			if(index == size) {
				if(end - start >= 1) {
					max = Math.max(max, arr[end] - arr[start]);
				}
				break;
			}
			if(arr[index] > num) {
				end = index;
				
			}else {
				if(end - start >= 1) {
					max = Math.max(max, arr[end] - arr[start]);
				}
				start = index;
			}
			num = arr[index];
			index++;
		}
		
		System.out.println(max);
	}
}
