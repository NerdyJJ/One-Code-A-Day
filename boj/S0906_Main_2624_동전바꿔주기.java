import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S0906_Main_2624_동전바꿔주기 {

	static int T; // 지폐 금액 ( 1 ~ 10000 )
	static int K; // 동전의 가지 수 ( 1 ~ 100 )
	static List<Coin> coinList;
	static int[] dp;

	static class Coin {
		int value, count;

		public Coin(int value, int count) {
			super();
			this.value = value;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		K = Integer.parseInt(br.readLine());

		coinList = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			coinList.add(new Coin(val, cnt));
		}

		dp = new int[T + 1];
		dp[0] = 1; // 아무것도 선택하지 않은 경우

		for (Coin c : coinList) {

			// T 부터 거꾸로 dp
			for (int i = T; i > 0; i--) {

				for (int j = 1; j <= c.count; j++) {
					int temp = j * c.value;
					if (i - temp >= 0) {
						dp[i] += dp[i - temp];
					}
				}
			}

		}

		System.out.println(dp[T]);
	}
}
