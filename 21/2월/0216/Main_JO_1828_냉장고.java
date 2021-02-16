package problem210216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고 {
	static int N;

	private static class Chemistry implements Comparable<Chemistry> {
		int minDegree;
		int maxDegree;

		public Chemistry(int minDegree, int maxDegree) {
			this.minDegree = minDegree;
			this.maxDegree = maxDegree;
		}

		@Override
		public int compareTo(Chemistry o) {
			int value = this.minDegree - o.minDegree;
			if (value == 0) {
				return this.maxDegree - o.maxDegree;
			}
			return value; // 최저온도

		}

		@Override
		public String toString() {
			return "Chemistry [minDegree=" + minDegree + ", maxDegree=" + maxDegree + "]";
		}

	}

	private static int findRefridgeratorNum(List<Chemistry> arr) {
		int refNum = 1;
		int refMin = arr.get(0).minDegree, refMax = arr.get(0).maxDegree; // 냉장고 범위 기준(초기 = 제일 처음 화학물질 온도 min, max)

		for (int i = 1; i < N; i++) {
			int nStart = arr.get(i).minDegree; // 현재 화학물질 최저온도
			int nEnd = arr.get(i).maxDegree; // 현재 화학물질 최고온도

			if (refMin <= nStart && nEnd <= refMax) { // 냉장고 범위 안에 현재 화학물질 최저/최고 온도가 포함될 시,
				refMin = nStart; // 냉장고 범위를 현재 화학물질 최저
				refMax = nEnd; // 최고 온도로 바꿔준다.
			}

			if (nStart > refMax) { // 냉장고 최고 범위보다 현재 화학물질 최저온도가 크면,
				refMin = nStart; // 냉장고 최저온도를 현재 최저온도로
				refMax = nEnd; // 냉장고 최고온도를 현재 최고온도로 바꿔주고
				++refNum; // 냉장고 수를 증가시킨다.
			}
		}
		return refNum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		List<Chemistry> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr.add(new Chemistry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(arr);
		System.out.println(findRefridgeratorNum(arr));

	}

}
