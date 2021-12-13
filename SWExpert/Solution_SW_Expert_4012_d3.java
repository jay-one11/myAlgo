import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SW_Expert_4012_d3 {
	static int T;
	static int N;
	static int[][] ingred;
	static int R ;
	static int min = Integer.MAX_VALUE;
	static int[] food1;
	static int[] food2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			R = N/2;
			ingred = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int k = 0; k < N; k++) {
					ingred[j][k] = Integer.parseInt(st.nextToken());
				}
				
			}
			food1 = new int[R];
			food2 = new int[R];
			comb(0,0);
			System.out.println("#"+i+" "+min);
		}
	}

	private static void comb(int cnt, int start) {
		if(cnt == R) {
			int idx=0;
			for (int i = 0; i < N; i++) {
				int flag = 1;
				for (int j = 0; j < R; j++) {
					if(food1[j] == i) {
						flag = 0;
						break; // food1의 식재료인경우
				}
				}
				if(flag == 1) {
					food2[idx++] = i; // food1의 식재료가 아닌경우 -> food2
				}
			}
			
			int F1 = 0;
			int F2 = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < R; j++) {
					F1 += ingred[food1[i]][food1[j]];
					F2 += ingred[food2[i]][food2[j]];
				}
			}
			int tot = Math.abs(F1-F2);
			min = Math.min(tot, min);
			return;
		}
		for (int i = start; i < N; i++) {
			food1[cnt] = i;
			comb(cnt+1,i+1);
		}
	}

}
