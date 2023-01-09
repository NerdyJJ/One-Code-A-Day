import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S0109_Main_2309_일곱난쟁이 {
	
	static int[] dwarfs = new int[9];

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dwarfs);
		
		int numA = 0;
		int numB = 1;
		
		while(numA < 8) {
			int sum = 0;
			
			for (int i = 0; i < 9; i++) {
				if(i != numA && i != numB) {
					sum += dwarfs[i];
				}
			}
			
			if(sum == 100) {
				for (int i = 0; i < 9; i++) {
					if(i != numA && i != numB) {
						System.out.println(dwarfs[i]);
					}
				}
				return;
			} else {
				if(numB >= 8) {
					numA++;
					numB = numA + 1;
				} else {
					numB++;
				}
			}
		}
		
	}

}
