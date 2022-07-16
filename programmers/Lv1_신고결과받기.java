import java.util.*;

public class Lv1_신고결과받기 {

	public int[] solution(String[] id_list, String[] report, int k) {
        int user_count = id_list.length;
        int[] answer = new int[user_count];
        
        HashMap<String, Integer> user_idx = new HashMap<String, Integer>();
        
        for(int i = 0; i < user_count; i++){
            user_idx.put(id_list[i], i);
        }
        
        boolean[][] report_status = new boolean[user_count][user_count];
        
        for(String str : report){
            StringTokenizer st = new StringTokenizer(str);
            int a = user_idx.get(st.nextToken());
            int b = user_idx.get(st.nextToken());
            
            if(!report_status[a][b]) report_status[a][b] = true;
        }
        
        boolean[] reported_limit_over = new boolean[user_count];
        for(int i = 0; i < user_count; i++){
            int c = 0;
            for(int j = 0; j < user_count; j++){
                if(report_status[j][i]) c++;
            }
            if(c >= k) reported_limit_over[i] = true;
        }
        
        for(int i = 0; i < user_count; i++){
            for(int j = 0; j < user_count; j++){
                if(reported_limit_over[j] && report_status[i][j]){   
                    answer[i]++;    
                }    
            }
        }
        
        return answer;
    }
}
