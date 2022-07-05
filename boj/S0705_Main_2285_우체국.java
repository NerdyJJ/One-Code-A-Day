import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S0705_Main_2285_우체국 {

	// idx 기준 좌우 인구수 차이가 최소가 될때, 거리합도 최소가 될 가능성
	// 인구수가 0인 지역 (마을이 아닌곳)을 idx로 잡는건 무의미 >> 마을에 지을때, 해당 인구수만큼 거리가 줄게됨

	// TownList 를 돌면서 인구수 누적합 계산, 누적합이 총 인구의 절반을 넘어갈때 >> 거리합 최소

	static int N; // 마을의 개수 1 ~ 10만

	static ArrayList<Town> townList;
	static long totalPop; // 총 인구수
	static long subPop; // 인구 누적합
	static int result;

	static class Town implements Comparable<Town> {
		int t, k;

		public Town(int t, int k) {
			super();
			this.t = t;
			this.k = k;
		}

		@Override
		public int compareTo(Town o) {
			// TODO Auto-generated method stub
			return t - o.t;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		townList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			totalPop += k;

			townList.add(new Town(t, k));
		}

		Collections.sort(townList);

		for (Town town : townList) {
			subPop += town.k;

			if (subPop >= ((totalPop + 1) / 2)) { // 총 인구수가  홀수일 경우를 대비해 +1 처리
				System.out.println(town.t);
				break;
			}
		}
	}

}
