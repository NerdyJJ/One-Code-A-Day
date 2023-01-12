import java.io.*;
import java.util.*;

public class S0112_Main_10025_게으른백곰 {
	
	static int N; // 얼음양동이 개수 (1 ~ 100000)
	static int K; // 좌우 리치 (1 ~ 2000000)
	
	static int[] ice = new int[1000001];
	
	static int maxSum = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int maxX = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			ice[x] = g;
			maxX = Math.max(maxX, x);
		}
		
		
		int sum = 0;
		for (int i = 0; i <= Math.min(K, maxX); i++) {
			sum += ice[i];
		}
	
		
		int idx = 0;
		
		while(idx < maxX) {
			idx++;
			if(idx-K > 0) sum -= ice[idx-K-1];
			
			if(idx+K <= maxX) sum += ice[idx+K];
			
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);

	}

}
