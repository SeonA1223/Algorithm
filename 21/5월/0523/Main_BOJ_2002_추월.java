package Day210523;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_2002_추월 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map.put(s, i);
		}
		
		boolean visited[] = new boolean[map.size()];
		int exNum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int n = map.get(s);
			visited[n] = true;
			if(n > exNum) cnt++;
			if(n == exNum) {
				for (int j = exNum+1; j < map.size(); j++) {
					if(visited[j]) continue;
					exNum = j;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
