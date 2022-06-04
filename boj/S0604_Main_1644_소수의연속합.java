import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S0604_Main_1644_소수의연속합 {
	
	static int N; // 400만
	
	static Queue<Integer> q;
	static int result;
	static boolean[] p;
	
	// 1. 소수판별 > 더하면서 큐에 저장
	// 2. 연속합이 N을 초과하면 N이하가 될 때까지 빼면서 큐에서 제거
	
	// 2-1. 연속합이 N이 되면 count++
	// 2-2. 판별하는 숫자가 N이 될때까지 진행
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		q = new LinkedList<>();
		p = new boolean[N+1];
		
		Arrays.fill(p, true);
		
		// 소수 판별
		for (int i = 2; i <= N; i++) {
			if(!p[i]) continue;
			
			for (int j = i * 2; j <= N; j += i) {
				p[j] = false;
			}
		}
		
		// 위에서 구한 소수들 더하면서 큐에 저장
		
		int psum = 0;
		for (int i = 2; i <= N; i++) {
			if(p[i]) {
				q.add(i);
				psum += i;
				
				while (psum > N) {
					psum -= q.poll();
				}
				
				if(psum == N) result++;
			}
		}
		
		System.out.println(result);
	}

}
