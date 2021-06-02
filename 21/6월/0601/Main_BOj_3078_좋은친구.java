package Day210601;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1시간 걸림
public class Main_BOj_3078_좋은친구 {
	static int N, K;
	static long res;
	static int[] studentsNameLength;
	static int[] nameLength; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		K = Integer.parseInt(st.nextToken()); // 등수 차이
		nameLength = new int[21];
		res = 0;
		studentsNameLength = new int[N];
		for (int i = 0; i < N; i++) {
			studentsNameLength[i] = br.readLine().length();
		}

		int firstStudentNameLength = studentsNameLength[0];
		for (int i = 1; i <= K; i++) {
			if (firstStudentNameLength == studentsNameLength[i])
				res++;
			nameLength[studentsNameLength[i]]++;
		}

		int current = 1;
		int next = K + 1;
		while (current < N - 1) {
			if (next < N) {
				nameLength[studentsNameLength[next]]++;
			}
			if (nameLength[studentsNameLength[current]] != 0)
				nameLength[studentsNameLength[current]]--;
			int leng = studentsNameLength[current];
			if (nameLength[leng] != 0)
				res += nameLength[leng];
			current++;
			next++;
		}

		System.out.println(res);

	}
}
