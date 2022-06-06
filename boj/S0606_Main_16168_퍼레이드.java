import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S0606_Main_16168_퍼레이드 {

	// 한붓그리기 (오일러 서킷, 오일러 트레일)

	// 여기서는 출발지점으로 돌아와야 한다는 조건 x --> 오일러 트레일

	// 연결된 간선의 개수가 홀수인 정점이 0 혹은 2개

	static int V, E; // 1 <= V <= E <= 3000

	static ArrayList<Integer>[] adjList;
	static boolean[][] visited;

	static String result = "NO";
	
	static void dfs(int now, int count) {
		if(count == E) {
			result = "YES";
			return;
		}
		
		for (int i = 0; i < adjList[now].size(); i++) {
			int next = adjList[now].get(i);
			if(visited[now][next] && visited[next][now]) continue;
			visited[now][next] = visited[next][now] = true;
			dfs(next, ++count);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adjList[start].add(end);
			adjList[end].add(start);
		}

		visited = new boolean[V+1][V+1];
		dfs(1, 0);
		
		int cnt = 0;
		for (int i = 1; i <= V; i++) {
			if (adjList[i].size() % 2 != 0) {
				cnt++;
			} else
				continue;
		}

		if (!(cnt == 0 || cnt == 2))
			result = "NO";

		System.out.println(result);
	}

	// 그래프가 하나로 연결되어 있지 않는 경우 존재!
	// dfs를 이용해 그래프가 연결되어있는지 확인할 필요가 있다.
	
	// 모든 간선들에 대해서 방문체크 하지않고
	// dfs 탐색을 진행하면서 정점에 대해서만 방문여부를 체크한다면 그래프 개수를 파악할 수 있다. >> 메모리 절약

	// https://settembre.tistory.com/282

}
