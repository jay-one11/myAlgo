import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_Expert_7272_D3 {
	static int T;
	static String s = " CEFGHIJKLMNSTUVWXYZ";
	static char[] alpha0 = s.toCharArray();
	static String ss = "ADOPQR";
	static char[] alpha1 = ss.toCharArray();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		String result = "";
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();
			if(A.length != B.length) { // 개수가 다른 경우
				result = "DIFF";
			}
			else {
				for (int x = 0; x < B.length; x++) {
					if(DetectSameAlpha(A[x], B[x])!=1) {
						result = "DIFF";
						break;
					}
					else {
						result ="SAME";
					}
				}		
			}
			
		System.out.printf("#%d %s%n",(i+1),result);
			
			
		}
	}
	private static int DetectSameAlpha(char a, char b) {
		
		int a_idx = -1;
		int b_idx = -1;
		
		if(a == 'B') {
			a_idx = 1;
		}
		if(b == 'B') {
			b_idx = 1;
		}
		for (int i = 0; i < alpha0.length; i++) {
			if(alpha0[i] == a) {
				a_idx = 2;
			}
			if(alpha0[i] == b) {
				b_idx = 2;
			}
		}
		for (int i = 0; i < alpha1.length; i++) {
			if(alpha1[i] == a) {
				a_idx = 3;
			}
			if(alpha1[i] == b) {
				b_idx = 3;
			}
		}
		
		if(a_idx == b_idx) return 1;
		else return 0;

		
		
		
	}
	
}
