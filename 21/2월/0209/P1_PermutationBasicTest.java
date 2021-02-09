package problem210209;
import java.util.Arrays;

public class P1_PermutationBasicTest {
	
	// 1,2,3
	// 3자리수 순열
	// 3P3 = 3!
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		permutation(0);
	}
	
	static int N=4,R=4;
	static int[] numbers;
	static boolean[] isSelected;

	public static void permutation(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1; i<=N; ++i) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}