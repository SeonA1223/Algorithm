package problem210329;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_13706_제곱근 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double N = Double.parseDouble(br.readLine());
		
		double res = Math.sqrt(N);
		
		System.out.println(Math.floor(res));
	}
}
