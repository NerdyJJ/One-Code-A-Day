import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S0725_Main_1713_후보추천하기 {
	
	static int N; // 사진틀 개수 1 ~ 20
	static int K; // 총 추천횟수 1 ~ 1000
	static int[] cd; // 후보 추천
	
	static List<Fuck> list;
	
	static class Fuck implements Comparable<Fuck>{
		int num;
		int cnt_cd;
		
		public Fuck(int num, int cnt_cd) {
			super();
			this.num = num;
			this.cnt_cd = cnt_cd;
		}

		@Override
		public int compareTo(Fuck o) {
			// TODO Auto-generated method stub
			return num - o.num;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		cd = new int[K];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			cd[i] = Integer.parseInt(st.nextToken());
		}
		
		// end of Input
		
		list = new ArrayList<>();
		
		for (int i = 0; i < K; i++) {
			int n = cd[i];
			
			if(list.isEmpty()) {
				list.add(new Fuck(n, 1));
			} else {
				boolean updated = false;
				for (int j = 0; j < list.size(); j++) {
					Fuck temp = list.get(j);
					
					if(n == temp.num) {
						list.set(j, new Fuck(n, temp.cnt_cd+1));
//						list.remove(j);
//						list.add(new Fuck(n, temp.num + 1));
						updated = true;
						break;
					}
				}
				if(!updated) {
//					System.out.println("노업");
					if(list.size() < N) {
						list.add(new Fuck(n, 1));
					} else {
						int min_value = 1000;
						int min_idx = 0;
						for (int j = 0; j < N; j++) {
							Fuck temp = list.get(j);
							if(min_value > temp.cnt_cd) {
								min_idx = j;
								min_value = temp.cnt_cd;
							}
						}
						list.remove(min_idx);
						list.add(new Fuck(n, 1));
					}
				}
			}
		
			
//			for (Fuck f : list) {
//				System.out.print(f.num + " ");
//			}
//			System.out.println();
//			System.out.println("---");
		}
		
		Collections.sort(list);
		
		for (Fuck f : list) {
			System.out.print(f.num + " ");
		}
		
		
	}

}
