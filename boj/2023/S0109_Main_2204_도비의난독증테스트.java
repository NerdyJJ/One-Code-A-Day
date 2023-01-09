import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S0109_Main_2204_도비의난독증테스트 {
	
	static int N; // (2 ~ 1000)
	static String[] words;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) return;
			
			words = new String[N];
			
			for (int i = 0; i < N; i++) {
				words[i] = br.readLine();
			}
			
			int min = 0;
			int next = min+1;
			while(true) {
				if(next >= N) {
					System.out.println(words[min]);
					break;
				}
				if(words[min].toUpperCase().compareTo(words[next].toUpperCase()) > 0) {
					min = next;
					next = min + 1;
				} else {
					next++;
				}
			}
			
		}
	}

}
