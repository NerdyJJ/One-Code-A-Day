import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class S0706_Main_2253_점프 {

	static int N; // 2 ~ 10000
	static int M; // 0 <= M <= N-2
	static final int MAXX = Integer.MAX_VALUE;

	static int result;

	static int[][] stone;
	static Set<Integer> small;

	static Queue<State> q;

	static class State {
		int idx, speed;
		int step;

		public State(int idx, int speed, int step) {
			super();
			this.idx = idx;
			this.speed = speed;
			this.step = step;
		}
	}

	static void jump() {
		while (!q.isEmpty()) {
			State s = q.poll();

			int idx = s.idx;
			int speed = s.speed;
			int step = s.step;

			for (int i = -1; i <= 1; i++) {
				int next = idx + speed + i;

				if (next == N) {
					result = step + 1;
					return;
				}

				if (isSmall(next))
					continue;

				if (next <= N && speed + i > 0 && stone[speed + i][next] == 0 ) {
					stone[speed + i][next] = step + 1;
					q.add(new State(next, speed + i, step + 1));
				}
			}
		}

		result = -1;
	}

	static boolean isSmall(int n) {
		if (small.contains(n))
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		stone = new int[150][N + 1];
		small = new HashSet<>();

		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(br.readLine());
			small.add(k);
		}

		q = new LinkedList<>();
		q.add(new State(1, 0, 0));

		jump();

		System.out.println(result);

		// 반례
		// 8 2
		// 3
		// 6

		// 무조건 최소값으로 갱신해버리면 8에 도달할 수 없음
		// speed에 따라 방문할 수 있는 좌표가 달라짐 -> 2차원 배열 이용
		
		// ----------------------------------------
		
		// 2차원 배열 BFS, Set 이용해서 메모리 효율 떨어짐 (84364 / 300)
		// DP로도 풀 수 있지 않을까?
	}

}
