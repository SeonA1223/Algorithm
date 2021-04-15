package Day210415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_JO_2577_회전초밥1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		int arr[] = new int[N + k];
		int visited[] = new int[d + 1];
		int count = 0;
		int res=0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < k; i++) {
			arr[N + i] = arr[i];
		}

		for (int i = 0; i < k; i++) {
			if (visited[arr[i]] == 0)
				count++;
			visited[arr[i]]++;
		}
		
		res = count;
		res = visited[c] == 0 ? res + 1 : res;
		

		int delete = 0;
		int start = k;
		
		while(start<N+k) {
			visited[arr[delete]]--;
			if(visited[arr[delete]]==0) count--;
			
			if(visited[arr[start]]==0)count++;
			visited[arr[start]]++;
			
			res = Math.max(res, visited[c] == 0 ? count+1:count);
			delete++;
			start++;
		}
		System.out.println(res);

	}
}
