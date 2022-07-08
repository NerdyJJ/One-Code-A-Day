import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S0708_Main_1106_호텔 {

	static int C; // 늘려야하는 고객수 1 ~ 1000
	static int N; // 홍보할 도시 개수 1 ~ 20
	
	static final int MAXX = 999999999;

	static int[] dp; // 고객 k명을 늘리는데 필요한 최소비용 dp
	static int result = MAXX;

	static ArrayList<Adv> advList;

	static class Adv implements Comparable<Adv> {
		int cost; // 1 ~ 100
		int customer; // 1 ~ 100

		public Adv(int cost, int customer) {
			super();
			this.cost = cost;
			this.customer = customer;
		}

		@Override
		public int compareTo(Adv o) {
			// TODO Auto-generated method stub
			if (cost == o.cost)
				return o.customer - customer;
			else
				return cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		

		advList = new ArrayList<>();

		int maxCustomer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			
			maxCustomer = Math.max(maxCustomer, customer);

			advList.add(new Adv(cost, customer));
		}
		
		dp = new int[C + maxCustomer + 1];
		Arrays.fill(dp, MAXX);
		dp[0] = 0;

		Collections.sort(advList);

		
//		int count = 0;
		for (Adv a : advList) {
//			System.out.println("----------");
//			System.out.println(a.cost + " " + a.customer);
			for (int i = a.customer; i < dp.length; i++) {
				if(dp[i] > dp[i - a.customer] + a.cost) {
					dp[i] = dp[i - a.customer] + a.cost;
//					System.out.println("갱신 > dp[" + i + "] : " + dp[i]);
//					count++;
				}
			}
		}
		
		for (int i = C; i < dp.length; i++) {
			result = Math.min(result, dp[i]);
		}
		
		System.out.println(result);

	}
}
