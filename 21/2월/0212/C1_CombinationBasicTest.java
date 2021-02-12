package problem210212_보충;
import java.util.Arrays;
import java.util.Scanner;

public class C1_CombinationBasicTest {

	// 1,2,3
	// 3C2 = 3!/1!2! = 3
	static int N,R;
	static int[] input,numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		long start = System.nanoTime();
		combination(0,0);
		long end = System.nanoTime();
		System.out.println(end-start);
	}

	private static void combination(int cnt,int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<N; ++i) {
			numbers[cnt] = input[i];
			combination(cnt+1,i+1);
		}
	}
}
