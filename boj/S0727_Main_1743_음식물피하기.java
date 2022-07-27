import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0727_Main_1743_음식물피하기 {

	static int N; // 1 ~ 100
	static int M; // 1 ~ 100
	static int K; // 1 ~ 10000

	static boolean[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static List<Pos> foods;
	static Queue<Pos> q;

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static void check4d(int a, int b) {
		
		int cnt = 1;
		
		q.add(new Pos(a, b));
		visited[a][b] = true;
		
		while (!q.isEmpty()) {
			Pos now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r + delta[i][0];
				int nc = now.c + delta[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					cnt++;
					q.add(new Pos(nr, nc));
				}
			}
		}
		
		result = Math.max(result, cnt);
	}

	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		visited = new boolean[N][M];
		foods = new ArrayList<>();
		q = new LinkedList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = true;
			foods.add(new Pos(r, c));
		}

		for (Pos now : foods) {
			int r = now.r;
			int c = now.c;

			check4d(r, c);
		}

		System.out.println(result);
	}

}
