package problem210319;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N; // 도시수
    static int[] p;
    static int[][] map; // 도시 연결관리 인접 행렬
    static int[] teams;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        p = new int[N+1]; // 0번 버림
        map = new int[N+1][N+1];
        teams = new int[N+1];

        for(int i = 1 ; i <= N; i++) {
            p[i] = sc.nextInt();
        }
        int cnt = 0;
        int k;
        for(int i = 1; i <= N; i++) {
            cnt = sc.nextInt();
            for(int j = 0 ; j < cnt ; j++) {
                k = sc.nextInt();
                map[i][k] = 1;
                map[k][i] = 1;
            }
        }
//        솔루션
        dfs(1);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }
//    현재 위치의 도시를
    static void dfs(int idx) {
        if(idx == N + 1) {
//            솔루션 구현
            if(check(0) && check(1)) {
                int r = getCount();
                res = Math.min(res, r);
            }
            return;
        }
        teams[idx] = 0;
        dfs(idx + 1);
        teams[idx] = 1;
        dfs(idx + 1);
    }
    private static int getCount() {
        int team1 = 0;
        int team2 = 0;
        for(int i = 1; i <= N; i++) {
            if(teams[i] == 0) {
                team1 += p[i];
            }else {
                team2 += p[i];
            }
        }
        return Math.abs(team1 - team2);
    }
    private static boolean check(int type) {
        boolean[] v = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(teams[i] == type) {
                q.offer(i);
                v[i] = true;
                break;
            }
        }

        if(q.size() == 0) {
            return false;
        }
        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 1; i<= N; i++) {
                if(map[cur][i] == 0) {
                    continue;
                }
                if(v[i]) {
                    continue;
                }
                if(teams[i] != type) {
                    continue;
                }
                v[i] = true;
                q.offer(i);
            }
        }

        for(int i =1; i <=N; i++) {
            if(teams[i] != type) {
                continue;
            }
            if(!v[i]) {
                return false;
            }
        }

        return true;
    }
}

