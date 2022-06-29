import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0629_Main_2178_미로탐색 {

	// 단순 BFS 문제

	static int N, M; // 2 ~ 100
	static char[][] map;
	static Queue<Pos> q;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int result;

	static class Pos {
		int x, y;
		int step;

		public Pos(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	static void bfs() {
		q = new LinkedList<>();
		visited = new boolean[N][M];

		q.add(new Pos(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {

			Pos now = q.poll();
			int step = now.step;
			
			if(now.x == N-1 && now.y == M-1) {
				result = step;
				break;
			}

			for (int i = 0; i < delta.length; i++) {
				int nr = now.x + delta[i][0];
				int nc = now.y + delta[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '1') {
					q.add(new Pos(nr, nc, step+1));
					visited[nr][nc] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bfs();
		System.out.println(result);
	}

}
