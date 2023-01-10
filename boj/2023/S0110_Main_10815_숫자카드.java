import java.io.*;
import java.util.*;

public class S0110_Main_10815_숫자카드 {
	
	static int N; // 상근이 숫자 카드 개수 (1 ~ 500000)
	static int[] hands;
	static int M; // 판단할 숫자 카드 개수 (1 ~ 500000)

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		hands = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hands[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hands);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int left = 0;
			int right = N-1;
			while(left <= right) {
				int k = (left + right) / 2;
				if(hands[k] == num) {
					sb.append("1 ");
					break;
				} else if(hands[k] < num) {
					left = k + 1;
				} else {
					right = k - 1;
				}
			}
			
			if(left > right) sb.append("0 ");
		}
		
		System.out.println(sb.toString());
		
		// System.out.println() 사용할 때 3500ms
		// StringBuilder 사용할 때 1072ms
		// 차이가 크다!!
	}

}
