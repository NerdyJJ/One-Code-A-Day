import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S0602_Main_15685_드래곤커브 {
	
	// https://www.acmicpc.net/problem/15685

	static int N; // 20
	static int[] dc;
	static boolean[][] map; // 100
	static int result;
	
	static double baseLog(double x, double base) {
		return Math.log(x) / Math.log(base);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); // 시작x 100
			int y = Integer.parseInt(st.nextToken()); // 시작y 100
			int d = Integer.parseInt(st.nextToken()); // 방향 3 (우, 상, 좌, 하)
			int g = Integer.parseInt(st.nextToken()); // 세대 10
			
			int size = (int) Math.pow(2, g) + 1;
			dc = new int[size];
			
			dc[1] = d;
			map[x][y] = true;
			
			for (int j = 2; j < size; j++) {
				dc[j] = (dc[(int) Math.pow(2, Math.ceil(baseLog(j, 2))) + 1 - j] + 1) % 4;
			}
			
			for (int j = 1; j < size; j++) {
				switch (dc[j]) {
				case 0:
					x++;
					break;
				case 1:
					y--;
					break;
				case 2:
					x--;
					break;
				case 3:
					y++;
					break;
				}
				
				
				if(x >= 0 && x <= 100 && y >= 0 && y <= 100) {
					map[x][y] = true;
				}
			}			
			
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
		
		// dc(x, y, d, g) >> 

		// dc(n) = dc(n-1) + reverse(dc(n-1)+1)
		
		// dc.length = Math.pow(2, 3) = 8 (9)
		// dc[1] = d
		// dc[2] = d+1
		
		// dc[3] = dc[2] + 1
		// dc[4] = dc[1] + 1
		
		// dc[5] = dc[4] + 1
		// dc[6] = dc[3] + 1
		// dc[7] = dc[2] + 1
		// dc[8] = dc[1] + 1
		
		// dc[i] = dc[(int) Math.pow(2, Math.ceil(baseLog(i, 2))) + 1 - i] + 1;
		
		
	}

}
