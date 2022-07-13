import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0713_Main_1932_정수삼각형 {
	
	static int N; // 삼각형의 크기 1 ~ 500
	
	static int[][] triangle;
	static int[][] dp;

	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		triangle = new int[N][N];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = triangle[0][0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {				
				
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				} else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp[N-1][i]);
		}

		System.out.println(result);
	}

}
