import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S0602_Main_14699_관악산등산 {
	
	// https://www.acmicpc.net/problem/14699

	static int N; // 쉼터 5000
	static int M; // 길 10만
	static int[] H; // 쉼터 높이
	static ArrayList<Node> nodeList;
	static ArrayList<Node>[] connected;
	
	static int[] dp;

	static class Node implements Comparable<Node>{
		int n;
		int height;

		public Node(int n, int height) {
			super();
			this.n = n;
			this.height = height;
		}
		
		@Override
		public int compareTo(Node o) {
			return o.height - this.height;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		nodeList = new ArrayList<>();
		connected = new ArrayList[N + 1];
		
		dp = new int[N+1];

		for (int i = 1; i <= N; i++) {
			connected[i] = new ArrayList<>();
			int height = Integer.parseInt(st.nextToken());
			H[i] = height;
			nodeList.add(new Node(i, height));
		}
		
		Collections.sort(nodeList);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// 현재 위치보다 높은 쉼터로의 경로만 추가 (낮은방향은 제외)
			if(H[start] > H[end]) {
				connected[end].add(new Node(start, H[start]));
			} else {
				connected[start].add(new Node(end, H[end]));
			}
		}
		
		for (Node n : nodeList) {
			int idx = n.n;
			
			// 연결된 쉼터 리스트를 높이순으로 정렬
			Collections.sort(connected[idx]);
			
			// 연결된 쉼터가 2개 이상이면 그들 중 max를 추가
			if(connected[idx].size() > 1) {
				int temp = 0;
				for (Node conn : connected[idx]) {
					temp = Math.max(temp, dp[conn.n]);
				}
				dp[idx] += temp;
			// 연결된 쉼터가 1개이면 그 값을 추가
			} else if (connected[idx].size() == 1) {
				for (Node conn : connected[idx]) {
					dp[idx] += dp[conn.n];
				}
			}
			
			// 현재 위치도 포함하므로 추가
			dp[idx]++;
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}

}
