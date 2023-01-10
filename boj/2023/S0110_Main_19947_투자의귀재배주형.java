import java.io.*;
import java.util.*;

public class S0110_Main_19947_투자의귀재배주형 {
	
	static int H; // 초기비용 (10000 ~ 100000)
	static int Y; // 투자기간 (0 ~ 10)
	
	static int[][] dp;
	
	static final double iA = 1.05;
	static final double iB = 1.2;
	static final double iC = 1.35;
	
	static int result;
	
	// A : 1년마다 5% 이자
	// B : 3년마다 20% 이자
	// C : 5년마다 35% 이자
	// 소수점 이하 버림

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		dp = new int[3][Y+1];
		
		dp[0][0] = dp[1][0] = dp[2][0] = H;
		
		for (int i = 1; i <= Y; i++) {
			// A
			int p = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
			dp[0][i] = (int) Math.floor(p * iA);
			
			// B
			if(i >= 3) { // --> 매년 바꿀수 있으므로, i%3 == 0 사용하면 안됩니다
				p = Math.max(Math.max(dp[0][i-3], dp[1][i-3]), dp[2][i-3]);
				dp[1][i] = (int) Math.floor(p * iB);
			} else {
				dp[1][i] = dp[1][i-1];
			}
			
			// C
			if(i >= 5) { // 마찬가지
				p = Math.max(Math.max(dp[0][i-5], dp[1][i-5]), dp[2][i-5]);
				dp[2][i] = (int) Math.floor(p * iC);
			} else {
				dp[2][i] = dp[2][i-1];
			}
		}
		
		result = Math.max(Math.max(dp[0][Y], dp[1][Y]), dp[2][Y]);
		System.out.println(result);
	}

}
