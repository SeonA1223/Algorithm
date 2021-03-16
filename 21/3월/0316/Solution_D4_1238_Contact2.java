package problem210316;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_D4_1238_Contact2 {
    static LinkedList<Node> list[];
    static Node[] visit;
    static int s;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n;
 
        for(int t=1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            visit = new Node[100+1];
            list = new LinkedList[100+1];
            for(int i=0; i<101; i++) {
                list[i] = new LinkedList<>();
                visit[i] = new Node(i, 0, 0);
            }
 
            st = new StringTokenizer(br.readLine());
            int x, y;
            for(int i=0; i<n; i+=2) {
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                list[x].add(new Node(y, x, 0));
            }
                 
            visit[s].count=1;
            search();
            Arrays.sort(visit);
            System.out.println("#" + t + " " + visit[100].x);
        }
    }
 
    static void search() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
         
        int count=0;
        int v;
        Node next;
        Iterator<Node> link;
        while (!queue.isEmpty()) {
            v= queue.poll();
             
            link = list[v].iterator();
            while (link.hasNext()) {
                next = link.next();
                 
                if(visit[next.x].count == 0) {
                    queue.offer(next.x);
                    visit[next.x].count = visit[next.y].count+1;
                }
            }
        }
    }
 
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;
 
        public Node(int x, int y, int count) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
        }
 
        @Override
        public int compareTo(Node o) {
            return this.x==o.x? this.x-o.x: this.count-o.count;
        }
    }
}