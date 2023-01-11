import java.io.*;
import java.util.*;

public class S0111_Main_16951_블록놀이 {
	
	static int maxMove = 1000;
	
	static int N; // 탑의 수 (1 ~ 1000)
	static int K; // 좋아하는 정수 (1 ~ 1000)
	
	static int[] block;
	static int[] answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		block = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new int[N];
		
		int err = 0;
		for (int i = 0; i < N; i++) {
			answer[i] = block[0] + (i * K);
			if(block[i] != answer[i]) err++;
		}
		maxMove = Math.min(maxMove, err);
		
		if(maxMove == 0) {
			System.out.println(maxMove);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 다음 블록과의 차이가 K인 경우 스킵 (다음 블록을 기준으로 체크)
			if(block[i + 1] - block[i] == K) continue;
			// i번째 블록이 정상인 경우에 이 블록을 중심으로 answer 나열한 뒤 err 카운트
			if(block[i] - (i * K) <= 0) continue;
			else {
				err = 0;
				for (int j = 0; j < N; j++) {
					answer[j] = block[i] - ((i - j) * K); 
					if(block[j] != answer[j]) err++;
				}
				
				maxMove = Math.min(maxMove, err);
				
				if(maxMove == 0) {
					System.out.println(maxMove);
					return;
				}
			}
		}
		
		System.out.println(maxMove);

	}

}
