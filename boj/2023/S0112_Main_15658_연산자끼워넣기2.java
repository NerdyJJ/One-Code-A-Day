import java.io.*;
import java.util.*;

public class S0112_Main_15658_연산자끼워넣기2 {
	
	static int N; // 숫자 개수 (2 ~ 11)
	static int[] num;
	static int[] ops = new int[4];
	
	static int maxResult = -1000000000;
	static int minResult = 1000000000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(1, num[0]);
		
		System.out.println(maxResult);
		System.out.println(minResult);
	}
	
	static void calc(int d, int n) {
		
		if(d >= N) {
			maxResult = Math.max(maxResult, n);
			minResult = Math.min(minResult, n);
			return;
		}
		
		if(ops[0] > 0) {
			ops[0]--;
			calc(d+1, n + num[d]);
			ops[0]++;
		}
		if(ops[1] > 0) {
			ops[1]--;
			calc(d+1, n - num[d]);
			ops[1]++;
		}
		if(ops[2] > 0) {
			ops[2]--;
			calc(d+1, n * num[d]);
			ops[2]++;
		}
		if(ops[3] > 0) {
			ops[3]--;
			calc(d+1, n / num[d]);
			ops[3]++;
		}
		
	}

}
