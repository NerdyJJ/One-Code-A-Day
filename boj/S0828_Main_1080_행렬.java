import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0828_Main_1080_행렬 {
	static int N, M; // ( 1 ~ 50 )
	static boolean[][] mat1, mat2;
	static int flipCnt;
	
	static void flip(int r, int c) {
		flipCnt++;
		for (int i = r-1; i <= r+1; i++) {
			for (int j = c-1; j <= c+1; j++) {
				mat1[i][j] = !mat1[i][j];
			}
		}
	}
	
	static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mat1[i][j] == mat2[i][j]) continue;
				else {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(flipCnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mat1 = new boolean[N][M];
		mat2 = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);

				if (ch == '1') mat1[i][j] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);

				if (ch == '1') mat2[i][j] = true;
			}
		}
				
		if(N < 3 && M < 3) {
			check();
			return;
		} else {
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if(mat1[i-1][j-1] == mat2[i-1][j-1]) continue;
					else flip(i, j);
				}
			}
			
			check();
			return;
		}
	}
}
