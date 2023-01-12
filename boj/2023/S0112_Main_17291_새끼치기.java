import java.io.*;
import java.util.*;

public class S0112_Main_17291_새끼치기 {
	
	static int N; // (1 ~ 20)
	static int[][] bugs;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		bugs = new int[N+1][2];
		
		bugs[1][0] = 1; // 1년초
		bugs[1][1] = 1; // 1년말
		
		for (int i = 2; i <= N; i++) {
			int cnt = 0;
			cnt = bugs[i-1][1] * 2; // 분열
			bugs[i][0] = cnt;
			
			if(i % 2 == 0) { // 사망
				// 홀수년도 태어난 벌레
				if(i-3 >= 0) {
					cnt -= (bugs[i-3][0] - bugs[i-4][1]);
					System.out.println("홀수 사망 : " + (bugs[i-3][0] - bugs[i-4][1]));
				}
				
				// 짝수년도 태어난 벌레
				if(i-4 > 0) {
					cnt -= (bugs[i-4][0] - bugs[i-5][1]);
					System.out.println("짝수 사망 : " + (bugs[i-4][0] - bugs[i-5][1]));
				}
			}
			
			bugs[i][1] = cnt;
		}
		
		System.out.println(bugs[N][1]);
	}

}
