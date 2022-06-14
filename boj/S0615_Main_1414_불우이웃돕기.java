import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S0615_Main_1414_불우이웃돕기 {

	// MST ? 프림알고리즘

	static int N; // 50 >> 2500
	static int[][] map;
	static boolean[] visited;
	static int total;
	static int result;

	static PriorityQueue<Edge> q;

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int MST(int node) {
		q = new PriorityQueue<>();

		visited = new boolean[N];
		q.add(new Edge(node, 0));

		int cnt = 0; // 연결된 정점 개수
		int cost = 0;
		while (!q.isEmpty()) {
			if (cnt == N) // N개 모두 방문했다면 그때의 cost를 뺀 나머지 값 반환
				break;

			Edge now = q.poll();

			if (visited[now.to])
				continue;
			else
				visited[now.to] = true;

			cost += now.weight;
			cnt++;

			for (int i = 0; i < N; i++) {
				int w1 = map[i][now.to];
				int w2 = map[now.to][i];

				if (w1 == Integer.MAX_VALUE && w2 == Integer.MAX_VALUE)
					continue;
				else
					q.offer(new Edge(i, Math.min(w1, w2))); // 간선중 비용이 가장 작은간선 연결
			}

		}

		if(cnt < N) return -1; // 모두 방문하지 못했을 경우 (연결안됨)
		else return total - cost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				int k;
				if(c != '0') {
					k = c - 'a' + 1;			
				} else k = Integer.MAX_VALUE; // 0인경우 (간선이 없는경우) 구분을 위해 INF
				
				if(k < 0) k += 32 + 26;
				
				map[i][j] = k;
				if(k != Integer.MAX_VALUE) total += k; // 모든 간선의 비용 합을 미리 계산
			}
		}
		
		result = -1;
		for (int i = 0; i < N; i++) {
			result = Math.max(MST(i), result);
		}
		
		System.out.println(result);
		
		
		
		
	}
}
