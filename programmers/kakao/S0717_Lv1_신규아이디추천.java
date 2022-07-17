package kakao;

public class S0717_Lv1_신규아이디추천 {

	public String solution(String new_id) {
        String answer = "";
        
        // step 1
        answer = new_id.toLowerCase();
        
        // step 2
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // step 3
        answer = answer.replaceAll("\\.+", ".");
         
        // step 4
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // step 5
        if(answer.length() == 0) answer += "a";
        
        // step 6
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, answer.length() - 1);
            } 
        }
        
        // step 7
        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length() - 1);
            }
        }
        
        return answer;
    }

}
