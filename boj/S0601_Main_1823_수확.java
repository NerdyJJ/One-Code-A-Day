import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S0601_Main_1823_수확 {
	
	// dp[left][right] : left ~ right 사이의 벼를 수확했을때 얻을 수 있는 최대 이익

	static int N; // 2000
	static int[] rice;
	static int[][] dp;
	static int result;

	static int harvest(int left, int right, int step) {
		
		// left가 right보다 커지면 안됨
		if (left > right)
			return 0;

		// 이전 기록이 있으면 패스
		if (dp[left][right] != 0)
			return dp[left][right];

		// left, right 수확했을때의 이익을 비교해서 최대값을 저장
		dp[left][right] = Math.max((harvest(left + 1, right, step + 1) + rice[left] * step),
				(harvest(left, right - 1, step + 1) + rice[right] * step));

		return dp[left][right];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		rice = new int[N + 1];
		dp = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			rice[i] = Integer.parseInt(br.readLine());
		}

		result = harvest(0, N - 1, 1);

		System.out.println(result);

	}
}
