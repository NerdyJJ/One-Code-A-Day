import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0831_Main_2589_보물섬 {
	
	static int R, C; // ( 1 ~ 50 )
	static char[][] map;
	
	static int[][] DT = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static Queue<Pos> q;
	static boolean[][] visited;
	
	static int maxDist;
	
	static class Pos {
		int r, c;
		int step;

		public Pos(int r, int c, int step) {
			super();
			this.r = r;
			this.c = c;
			this.step = step;
		}
	}
	
	static void check(int r, int c, int step) {
		visited = new boolean[R][C];
		
		q = new LinkedList<>();
		
		visited[r][c] = true;
		q.add(new Pos(r, c, step));
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r + DT[i][0];
				int nc = now.c + DT[i][1];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 'L' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc, now.step+1));
					
					maxDist = Math.max(maxDist, now.step+1);
				}
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'L') {
					check(i, j, 0);
				}
			}
		}
		
		System.out.println(maxDist);
	}
}
