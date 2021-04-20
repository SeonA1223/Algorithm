package Day210420;
import java.util.Scanner;
/*
JAVA
언어
26,584 kb
메모리
151 ms
실행시간
1,117
 */
public class Solution_D4_5604_구간합_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			long A = sc.nextLong();//5
			long B = sc.nextLong();//32
			
			long[] ans = new long[10];
			
			long point = 1;
			while (A <= B) {
				while (B % 10 != 9 && A <= B) {
					cal(B, ans, point);
					B--;
				}// 32 + 31 + 30
				
				
//				System.out.println("B:       "+B);//29
				if (B < A) {
					break;
				}
				while (A % 10 != 0 && A <= B) {
					cal(A, ans, point);
					A++;
				}//5+6+7+8+9
				
				
//				System.out.println("A:       "+A);//10
				A /= 10;
				B /= 10;
//				System.out.println("B2:       "+B);//2
//				System.out.println("A2:       "+A);//1
				for (int i = 0; i < 10; i++) {
					ans[i] += (B - A + 1) * point;
				}
				point *= 10;
			}
			
			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += (ans[i] * i);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	    sc.close();	
	}//main

	public static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0';
			ans[xx] += point;
			x /= 10;
		}
	}
}