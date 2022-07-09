import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S0709_Main_2157_여행 {

	static int N; // 도시 개수 1~300
	static int M; // 최대로 방문하는 도시 개수 2~N
	static int K; // 개설된 항공로의 개수 1~10만

	static int[][] map; // 항공로별 기내식 점수 map[a][b] = c
	static int[][] score; // step 이동횟수에 도시 k에 도착했을때 총 score

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if (a < b && map[a][b] < c) { // 작 큰
				map[a][b] = c;
			}
		}
		
//		System.out.println("---map---");
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("---------");

		score = new int[M][N];

		score[0][0] = 0;

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (i == 1) {
					score[i][j] = Math.max(score[i][j], score[0][0] + map[0][j]);
				} else {					
					if(score[i-1][j] != 0) {
						for (int k = j; k < N; k++) {
							if(map[j][k] != 0) { // j-k 경로가 존재하는 경우,
								score[i][k] = Math.max(score[i][k], score[i-1][j] + map[j][k]);								
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			result = Math.max(result, score[i][N-1]);
//			System.out.println(Arrays.toString(score[i]));
		}
		
		System.out.println(result);
		

	}

}
