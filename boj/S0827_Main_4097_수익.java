import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S0827_Main_4097_수익 {

	static int N; // ( 1 ~ 25만 )
	static int[] profit; // ( -10000 ~ 10000 )
	
	static long sum; // -25억 ~ 25억 >> long
	static long maxSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while ((N = Integer.parseInt(br.readLine())) != 0) {
			profit = new int[N];
			for (int i = 0; i < N; i++) {
				profit[i] = Integer.parseInt(br.readLine());
			}
			
			sum = 0;
			maxSum = Long.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				sum += profit[i];
				
				if(sum > maxSum) maxSum = sum;
				
				if(sum < 0) sum = 0;
			}
			System.out.println(maxSum);
		}
	}
}
