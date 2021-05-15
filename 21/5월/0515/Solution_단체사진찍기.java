package Day210515;
import java.util.*;

class Solution_단체사진찍기 {
    static final public int NUM = 8;
    static int res;
    static String cond[];
    static public Map<Character, Integer> map;
    
    public static void main(String[] args) {
    	String data[] = {"N~F=0", "R~T>2"};
		solution(2, data);
	}
    public static int solution(int n, String[] data) {
        cond = data;
        map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('F', 3);
        map.put('J', 4);
        map.put('M', 5);
        map.put('N', 6);
        map.put('R', 7);
        map.put('T', 8);
        
        res = 0;
        perm(0, new int[NUM], new boolean[NUM]);
        System.out.println(res);
        
        return res;
    }
    
    public static void perm(int cnt, int[] arr, boolean[] visited){
        if(cnt == NUM){
            if(check(arr)) res++;
            return;
        }
        for(int i=0; i<NUM; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i+1;
            perm(cnt+1, arr, visited);
            visited[i] = false;
        }
    }
    
    public static boolean check(int[] arr){
        for(int i=0; i<cond.length; i++){
            char one = cond[i].charAt(0);
            char two = cond[i].charAt(2);
            char four = cond[i].charAt(3);
            int five = cond[i].charAt(4) - '0' + 1; 
            
            int oneInt = map.get(one);
            int twoInt = map.get(two);
            int oneIndex = 0;
            int twoIndex = 0;
            for(int j=0; j<NUM; j++){
                if(arr[j] == oneInt) oneIndex = j;
                if(arr[j] == twoInt) twoIndex = j;
            }
            
            switch(four){
                case '=':
                    if(Math.abs(oneIndex - twoIndex) != five) return false;
                    break;
                case '<':
                    if(Math.abs(oneIndex - twoIndex) >= five) return false;
                    break;
                case '>':
                    if(Math.abs(oneIndex - twoIndex) <= five) return false;  
                    break;
            }
        }
        return true;
    }
}