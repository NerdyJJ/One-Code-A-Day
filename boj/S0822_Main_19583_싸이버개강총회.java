import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S0822_Main_19583_싸이버개강총회 {
	
	static String S, E, Q;
	static Set<String> checkIn;
	static Set<String> checkOut;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = st.nextToken();
		E = st.nextToken();
		Q = st.nextToken();
		
		checkIn = new HashSet<>();
		checkOut = new HashSet<>();
		
		String str;
		// while ((str = br.readLine()) != null) {
		// 왜 그러는지 잘 모르겠는데
		// 위의 코드로 하면 이클립스에서는 NoSuchElementException, 백준에서는 성공
		// 아래 코드로 하면 이클립스에서는 성공, 백준에서는 NullPointerException
		while ((str = br.readLine()).length() > 0) {
			st = new StringTokenizer(str);
			String time = st.nextToken();
			String nickname = st.nextToken();
			
			if(time.compareTo(S) <= 0) {
				checkIn.add(nickname);
			} else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
				checkOut.add(nickname);
			}
		}
		
		for (String nick : checkOut) {
			if(checkIn.contains(nick)) result++;
		}
		
		System.out.println(result);
	}
}
