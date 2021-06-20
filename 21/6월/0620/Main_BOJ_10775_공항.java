package problem210620;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_10775_공항 {
	static int Gate, Plane, res;
	static int planeDock[], parent[];

	static int find(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = find(parent[num]);
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa <= pb)
			parent[pb] = pa;
		else
			parent[pa] = pb;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gate = Integer.parseInt(br.readLine());
		Plane = Integer.parseInt(br.readLine());
		planeDock = new int[Plane];
		parent = new int[Gate + 1];
		res = 0;
		for (int i = 0; i < Plane; i++) {
			planeDock[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i <= Gate; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < Plane; i++) {
			int g = planeDock[i];
			int pg = find(g);
			if(pg > 0) {
				res++;
				union(pg-1, pg);
			}else {
				break;
			}
		}
		System.out.println(res);
	}
}
