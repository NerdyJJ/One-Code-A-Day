import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0604_Main_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {

	static int N, M; // 3000
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	static Queue<Pos> q;

	static class Pos {
		int x, y, step;

		public Pos(int x, int y, int step) {
			super();
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	static int bfs() {
		visited = new boolean[N][M];

		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			if(!visited[p.x][p.y]) visited[p.x][p.y] = true;
			
			if(map[p.x][p.y] > 2) return p.step;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + delta[i][0];
				int ny = p.y + delta[i][1];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
					visited[nx][ny] = true;
					q.add(new Pos(nx, ny, p.step+1));
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				int c = str.charAt(j) - '0';
				map[i][j] = c;

				if (c == 2) {
					q.add(new Pos(i, j, 0));
				}
			}
		}

		result = bfs();
		
		if(result >= 0) {
			System.out.println("TAK");
			System.out.println(result);
		} else {
			System.out.println("NIE");
		}

	}

}
