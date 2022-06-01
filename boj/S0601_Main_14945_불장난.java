import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S0601_Main_14945_불장난 {
	
	// https://www.acmicpc.net/problem/14945

	// 이동 방법은 총 4가지
	// (아래, 아래) / (대각, 대각) --> 거리 변함 x
	// (아래, 대각) --> 거리 +1
	// (대각, 아래) --> 거리 -1

	// 층수와 둘 사이의 거리를 이용 dp[층수 N][둘 사이의 거리 k]

	static int N; // 100
	static int[][] dp;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[101][103];

		// 초기값
		dp[2][1] = 2;

		for (int i = 3; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				// 거리 변함 없이 오는 경우 + 거리 증가한 경우 + 거리 감소한 경우
				dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 10007;
			}
		}

		for (int i = 1; i <= N; i++) {
			result += dp[N][i];
		}

		result %= 10007;

		System.out.println(result);
	}
}
