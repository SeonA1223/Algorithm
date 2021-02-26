package problem210226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2605_줄세우기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine().trim());
		int student = 1;
		LinkedList<Integer> list = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			int a = Integer.parseInt(st.nextToken());
			list.add(i-a, student++);			 
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
	}

}
