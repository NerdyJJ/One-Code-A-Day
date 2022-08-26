import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0826_Main_16927_배열돌리기2 {
	static int N, M; // (2 ~ 300)
	static int R; // (~ 10억)

	static int[][] arr;
	
	static void rotate(int sr, int sc, int rg, int cg, int rc) {
		for (int i = 0; i < rc; i++) {
			int temp = arr[sr][sc];
			
			for (int j = sc; j < sc+cg; j++) {
				arr[sr][j] = arr[sr][j+1];
			}
			
			for (int j = sr; j < sr+rg; j++) {
				arr[j][sc+cg] = arr[j+1][sc+cg];
			}
			
			for (int j = sc+cg; j > sc; j--) {
				arr[sr+rg][j] = arr[sr+rg][j-1];
			}
			
			for (int j = sr+rg; j > sr+1; j--) {
				arr[j][sc] = arr[j-1][sc];
			}
			
			arr[sr+1][sc] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int startR = 0;
		int startC = 0;
		
		int rowGap = N-1;
		int colGap = M-1;
		
		while(true) {
			if(rowGap <= 0 || colGap <= 0) break;
			int cycle = 2 * (rowGap + colGap);
			int rotateCnt = R % cycle;
			rotate(startR, startC, rowGap, colGap, rotateCnt);
			startR++;
			startC++;
			rowGap -= 2;
			colGap -= 2;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
