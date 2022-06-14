import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S0614_Main_14728_벼락치기 {

	static int N; // 100
	static int T; // 10000

	static int[][] dp; // 최대 n개의 과목을 풀 수 있다고 가정, 보유한 time, 최대로 얻을 수 있는 score; 
	static int result;

	static ArrayList<Cram> list;

	static class Cram implements Comparable<Cram> {
		int k, s;

		public Cram(int k, int s) {
			super();
			this.k = k;
			this.s = s;
		}

		public int compareTo(Cram o) {
			if(this.k != o.k) {
				return this.k - o.k;				
			} else {
				return o.s - this.s;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			list.add(new Cram(k, s));
		}
		
		Collections.sort(list);
		
//		for (Cram c : list) {
//			System.out.println(c.k + " " + c.s);
//		}
		
		dp = new int[N+1][T+1];
		Arrays.fill(dp[0], 0);
		
		for (int i = 1; i <= N; i++) {
			Cram c = list.get(i-1);
			int req_time = c.k;
			int score = c.s;
			
			for (int j = 1; j <= T; j++) {
				if(j-req_time >= 0) {
					dp[i][j] = Math.max(dp[i-1][j - req_time] + score, dp[i-1][j]);					
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][T]);
	}

}
