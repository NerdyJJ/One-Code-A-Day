import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0728_Main_16931_겉넓이구하기 {

	static int N; // 1 ~ 100
	static int M; // 1 ~ 100
	static int[][] map;
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) result += 2;
			}
		}
		
		// end of input
		
		// search from left
		for (int i = 0; i < N; i++) { // 행고정 열탐색
			for (int j = 0; j < M-1; j++) {
				int aa = map[i][j];
				int bb = map[i][j+1];
				
				result += Math.abs(aa-bb);
			}
			result += map[i][0];
			result += map[i][M-1];
		}
		
		// search from top
		for (int i = 0; i < M; i++) { // 열고정 행탐색
			for (int j = 0; j < N-1; j++) {
				int aa = map[j][i];
				int bb = map[j+1][i];
				
				result += Math.abs(aa-bb);
			}
			result += map[0][i];
			result += map[N-1][i];
		}
		
		System.out.println(result);
	}
}
