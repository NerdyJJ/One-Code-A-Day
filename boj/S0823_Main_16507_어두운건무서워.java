import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0823_Main_16507_어두운건무서워 {
	
	static int R, C; // (1 ~ 1000)
	static int Q;	// (1 ~ 10000)
	static int[][] photo;
	static int[][] prefixSum;
	
	// 2차원 prefixSum 이용!

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		photo = new int[R][C];
		prefixSum = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				photo[i][j] = Integer.parseInt(st.nextToken());
				
				if(i == 0 && j == 0) {
					prefixSum[i][j] = photo[i][j];
				} else if(i == 0) {
					prefixSum[i][j] = photo[i][j] + prefixSum[i][j-1];
				} else if(j == 0) {
					prefixSum[i][j] = photo[i][j] + prefixSum[i-1][j];
				} else {
					prefixSum[i][j] = photo[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
				}
			}
		}
		
		for (int i = 0; i < Q; i++) {
			int sum = 0;
			int avg = 0;
			st = new StringTokenizer(br.readLine());
			
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			
			if(r1 == 0 && c1 == 0) {
				sum = prefixSum[r2][c2];
			} else if(r1 == 0) {
				sum = prefixSum[r2][c2] - prefixSum[r2][c1-1];
			} else if(c1 == 0) {
				sum = prefixSum[r2][c2] - prefixSum[r1-1][c2];
			} else {
				sum = prefixSum[r2][c2] - prefixSum[r1-1][c2] - prefixSum[r2][c1-1] + prefixSum[r1-1][c1-1];
			}
			
			avg = sum / ((r2 - r1 + 1) * (c2 - c1 + 1));
			
			System.out.println(avg);
		}

	}

}
