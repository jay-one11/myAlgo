import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
	static int N;
	static int min = 99999;
	static int mol;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		while(true) {
			if(N%5 == 0) {
				mol += N/5;
				System.out.println(mol);
				break;
			}
			else {
				N-=3;
				mol+=1;
			}
			if(N<0) {
				System.out.println(-1);
				break;
			}
			
		}
		
		int mincount = Integer.MAX_VALUE;
		int f= 0;
		int t = 0;
		for (int i = 0; i <= N/5 ; i++) {
			if((N-(i*5))%3 == 0) {
				mincount = Math .min(mincount, i+((N-i*5)/3));
			}
			System.out.println(mincount == Integer.MAX_VALUE?-1:mincount);
		}
		
	}

}
