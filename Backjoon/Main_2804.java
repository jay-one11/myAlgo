import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		
		int idx_a = 0 ;
		int idx_b = 0 ;
		boolean flag = false;
		for (int a = 0; a < A.length; a++) {
			for (int b = 0; b < B.length; b++) {
				if(A[a] == B[b]) {
					idx_a = a; idx_b =b;
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		int A_top =0;
		int B_top =0;
		
		for (int x = 0; x < B.length; x++) {
			for (int y = 0; y < A.length; y++) {
				if(x==idx_b && y == idx_a) {
					System.out.print(B[B_top++]);
					A_top +=1;
				}
				else if(y==idx_a) { // 세로 일치일때
					System.out.print(B[B_top++]);
				}
				else if( x == idx_b) { // 가로 일치일때
					System.out.print(A[A_top++]);
				}
				else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
