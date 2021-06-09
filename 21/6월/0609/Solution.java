package Day210609;
import java.util.*;


class Solution {
    static List<String> list[];
    static Map<String, Integer> map;
    static int answer, length, banLength;
    
    public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban_id = {"fr*d*", "abc1**"};
		
		solution(user_id, ban_id);
		System.out.println(answer);
	}
    public static int solution(String[] user_id, String[] banned_id) {
        map = new HashMap<>();
        length = user_id.length;
        banLength = banned_id.length;
        list = new ArrayList[banLength];
        
        for(int i=0; i<length; i++){
            map.put(user_id[i], i);
        }
        
        for(int i=0; i<banned_id.length; i++){
        	list[i] = new ArrayList<>();
            matchUser(i, user_id, banned_id[i]);
            
        }
        
        // List<String> badUser = new ArrayList<>();
        answer = 0;
        boolean[] visited = new boolean[length];
        dfs(0, visited);
        
        // for(int i=0; i<length; i++){
        //     for(int j=0; j<list[i].size(); j++){
        //         System.out.println(list[i].get(j));
        //     }
        // }
        
        
        return answer;
    }
    
    static void dfs(int depth, boolean[] visited){
        if(depth == banLength){
            answer++;
            return;
        }
        for(int i=0; i<list[depth].size(); i++){
            String a = list[depth].get(i);
            int index = map.get(a);
             System.out.println("a " + a +" index " + index);
            if(visited[index]) continue;
            visited[index] = true;
            dfs(depth+1, visited);
            visited[index] = false;
        
        }
    }
    static void matchUser(int index, String[] user_id, String pattern){
        for(String s : user_id){
            boolean flag = true;
            if(pattern.length() == s.length()){
                for(int i=0; i<s.length(); i++){
                    if(pattern.charAt(i) == '*') continue;
                    else{
                        if(pattern.charAt(i) != s.charAt(i)){
                            flag = false;
                            break;
                        }  
                    }
                }
                if(flag){
                    // System.out.println(s);
                    list[index].add(s);
                }
            }
        }
    }
}