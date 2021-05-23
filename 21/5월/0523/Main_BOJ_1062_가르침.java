package Day210523;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1062_가르침 {
	static int N, K;
	static List<String> words;
	static StringBuilder s;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new ArrayList<>();
		s = new StringBuilder();
		ans = 0;
		
		// 단어를 다 자름
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			sb.delete(0, 4);
			sb.delete(sb.length() - 4, sb.length());
			words.add(sb.toString());
			s.append(sb);
		}

		int check = 0;
		check |= (1 << ('a' - 'a'));  
		check |= (1 << ('n' - 'a'));  
		check |= (1 << ('t' - 'a'));  
		check |= (1 << ('i' - 'a'));  
		check |= (1 << ('c' - 'a'));  
		teachKword(5, 0, check);
		System.out.println(ans);

	}

	private static void teachKword(int teachNum, int index, int check) {
		if(teachNum == K) {
			canReadNum(check);
			return;
		}
		

		for (int i = index; i < s.length(); i++) {
			char letter = s.charAt(i);
			if ((check & (1 << letter - 'a')) != 0)
				continue;
			teachKword(teachNum+1, i+1, check | ( 1 << (letter - 'a')));
		}

	}

	private static void canReadNum(int check) {
		int cnt = 0;
		for (int i = 0; i < words.size(); i++) {
			String sb = words.get(i);
			boolean flag = true;
			for (int j = 0; j < sb.length(); j++) {
				char c = sb.charAt(j);
				if((check & (1<<(c - 'a'))) == 0) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		ans = ans < cnt ? cnt : ans;
		
	}
}
