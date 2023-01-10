import java.util.*;
import java.io.*;

public class S0110_Main_14594_동방프로젝트Small {
	
	static int N; // 방의 개수 (2 ~ 100)
	static int M; // 행동 횟수 (0 ~ 100)
	static boolean[] walls;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			System.out.println(N);
			return;
		}
		
		walls = new boolean[N];
		for (int i = 0; i < N-1; i++) {
			walls[i] = true;
		}
		walls[N-1] = false;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			for (int j = from-1; j < to-1; j++) {
				if(walls[j]) walls[j] = false;
			}
		}
		
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if(walls[i]) cnt++;
		}
		
		System.out.println(cnt);
	}

}
