package problem210325;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_2644_촌수계산 {
    static int n;
    static int s, e; // 시작, 종료

    static ArrayList<Integer>[] list;
    static int res = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        e = sc.nextInt();
        int cnt = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++) {
            list[i] = new ArrayList<Integer>();
        }
        int from, to;
        for(int i = 0 ; i < cnt; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            list[from].add(to);
            list[to].add(from);
        }
        bfs();
        System.out.println(res);
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n+1];
        q.offer(s);
        v[s] = true;
        int size = 0;
        int level = 0;
        int cur;
        while(!q.isEmpty()) {
            size = q.size();
            level++;
            for(int i = 0 ; i < size ; i++) {
                cur = q.poll();
                ArrayList<Integer> temp = list[cur];
                int idx;
                for(int j = 0; j < temp.size(); j++) {
                    idx = temp.get(j);
                    if(idx == e) {
                        res = level ;
                        return;
                    }
                    if(v[idx]) {
                        continue;
                    }
                    q.offer(idx);
                    v[idx] = true;
                }
            }

        }
    }
}