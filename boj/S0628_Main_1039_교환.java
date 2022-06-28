import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S0628_Main_1039_교환 {

	static int N; // 1 ~ 100만
	static int K; // swap 횟수

	static int M; // 숫자 길이;
	static int cntNZ;

	static Queue<Change> q;
	static boolean[][] visited;

	static int result;

	static int swap(int num, int a, int b) {
		char[] ch = String.valueOf(num).toCharArray();
		
		// 바꿨을때 첫자리가 0이되는 경우는 예외처리
		if(a == 0 && ch[b] == '0') {
			return -1;
		}
		
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
		
		return Integer.parseInt(new String(ch));
	}


	static class Change {
		int num, cnt;

		public Change(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}

	static void bfs() {
		q = new LinkedList<>();
		visited = new boolean[1000001][11];

		q.add(new Change(N, 0));
		visited[N][0] = true;

		while (!q.isEmpty()) {
			Change c = q.poll();

			// K번 교환한 결과면 끝내고
			if (c.cnt == K) {
				result = Math.max(result, c.num);
				continue;
			}

			for (int i = 0; i < M - 1; i++) {
				for (int j = i + 1; j < M; j++) {
					int nc = swap(c.num, i, j);
					
					// 바꾼 결과가 이전에 체크한게 아니라면 큐에 다시 넣고
					if(nc != -1 && !visited[nc][c.cnt + 1]) {
						q.add(new Change(nc, c.cnt + 1));
						visited[nc][c.cnt + 1] = true;
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str_N = st.nextToken();
		N = Integer.parseInt(str_N);
		K = Integer.parseInt(st.nextToken());
		
		M = str_N.length();
		
		if(M == 1) {
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i < M; i++) {
			int n = str_N.charAt(i) - '0';
			if(n != 0) cntNZ++;
		}
		
		if(M == 2 && cntNZ == 1) {
			System.out.println(-1);
			return;
		}

		bfs();
		System.out.println(result);
	}
}