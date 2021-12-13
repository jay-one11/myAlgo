import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_Expert_4012_요리사 {
	static int T;
	static int N;
	static int[][] taste_map;
	static int R;
	static int lowest= Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			lowest= Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			// taste map 생성
			taste_map = new int[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < N; k++) {
					taste_map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			R = N/2;
			Comb(0,0,new boolean[N]);
			System.out.println("#"+(i+1)+" "+ lowest);
		}
	}

	private static void Comb(int cnt, int start,boolean[] v) {
		if(cnt == R) {
			int A_dish=0, B_dish=0;

			
			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if(v[a] && v[b]) {
						A_dish += taste_map[a][b];
					}
					else if(!(v[a] || v[b])) {
						B_dish += taste_map[a][b];
					}
				}
			}
			lowest = Math.min(Math.abs(A_dish-B_dish),lowest);
			return;
		}
		for (int i = start; i < N; i++) {
			if(v[i] == true) continue;
			v[i] = true;
			Comb(cnt+1,i+1,v);
			v[i] = false;
			
		}
		
		
		
		
		
		
	}
}
