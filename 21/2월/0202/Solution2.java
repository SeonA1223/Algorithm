package problem210202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution2 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		int testcase = Integer.parseInt(br.readLine());

//		int[][] line = br.readLine();
//		int[][] ladder = new int[][];
//		
		
		for(int i=0; i<testcase; i++) {
			StringBuilder sb = new StringBuilder();
			String s;
			int index = 1;
			while((s = br.readLine()) != null) {
				sb.append(s);
				index++;
			}
			
			br = new BufferedReader(new StringReader(sb.toString()));
			final int col = s.length();
			final int row = index;
			int[][] ladder = new int[row][col];
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			for(int j=0; j<row; j++) {
				for (int k = 0; k < col; k++) {
					ladder[j][k] = Integer.parseInt(tokens.nextToken());
				}
			}
		}
		
	}

}
