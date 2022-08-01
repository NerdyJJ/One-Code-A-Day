import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0801_Main_2660_회장뽑기 {
	
	static int N; // 1 ~ 50
	static int[][] friends;
	static int[] score;
	
	// 플로이드워셜? i k j
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		friends = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				friends[i][j] = 999;
			}
			friends[i][i] = 0;
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) break;
			
			friends[a][b] = friends[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
				}
			}
		}
		// 거리 계산 완료
		
		score = new int[N+1];
		score[0] = 999;
		
		int minP = 999;
		
		for (int i = 1; i <= N; i++) {
			int maxP = 0;
			for (int j = 1; j <= N; j++) {
				maxP = Math.max(maxP,  friends[i][j]);
			}
			score[i] = maxP;
			
			minP = Math.min(minP, maxP);
		}
		// 회장 후보 점수 계산 완료
		
		int cntP = 0;
		for (int i = 1; i <= N; i++) {
			if(score[i] == minP) {
				cntP++;
			}
		}
		// 후보 수 계산 완료
		
		System.out.println(minP + " " + cntP);
		
		for (int i = 1; i <= N; i++) {
			if(score[i] == minP) {
				System.out.print(i + " ");
			}
		}
		
	}
}
