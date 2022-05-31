import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S0531_Main_14675_단절점과단절선 {

	// https://www.acmicpc.net/problem/14675

	// 단절점(cut vertex) : 해당 정점을 제거하였을 때, 그 정점이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 정점을 단절점이라
	// 한다.
	// 단절선(bridge) : 해당 간선을 제거하였을 때, 그 간선이 포함된 그래프가 2개 이상으로 나뉘는 경우, 이 간선을 단절선이라 한다.

	// 트리(tree) : 사이클이 존재하지 않으며, 모든 정점이 연결되어 있는 그래프

	// 연결된 노드의 갯수가 2개 이상? 단절점
	// 모든 간선이 단절선

	static int N; // 10만
	static int q; // 10만
	static String result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		int[] nodeCount = new int[N + 1];

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodeCount[a]++;
			nodeCount[b]++;
		}

		q = Integer.parseInt(br.readLine());

		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			result = "no";

			if (t == 1) {
				if (nodeCount[k] >= 2)
					result = "yes";
			} else
				result = "yes";

			System.out.println(result);
		}
	}

}
