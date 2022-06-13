import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S0613_Main_10026_적록색약 {

	static int N; // 100

	static char[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static Queue<Pos> q;

	static int result1, result2;

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void bfs1() {
		visited = new boolean[N][N];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result1++;

					char ch = map[i][j];
					visited[i][j] = true;
					q.add(new Pos(i, j));

					while (!q.isEmpty()) {
						Pos now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nr = now.x + delta[k][0];
							int nc = now.y + delta[k][1];

							if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == ch) {
								visited[nr][nc] = true;
								q.add(new Pos(nr, nc));
							}
						}
					}
				}
			}
		}
	}
	static void bfs2() {
		visited = new boolean[N][N];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result2++;

					char ch = map[i][j];
					visited[i][j] = true;
					q.add(new Pos(i, j));

					while (!q.isEmpty()) {
						Pos now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nr = now.x + delta[k][0];
							int nc = now.y + delta[k][1];
							
							if(ch == 'R' || ch == 'G') {
								if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) {
									visited[nr][nc] = true;
									q.add(new Pos(nr, nc));
								}
							} else {
								if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == ch) {
									visited[nr][nc] = true;
									q.add(new Pos(nr, nc));
								}								
							}

						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bfs1();
		bfs2();

		System.out.println(result1 + " " + result2);
	}

}
