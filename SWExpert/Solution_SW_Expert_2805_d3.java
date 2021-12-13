import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SW_Expert_2805_d3 {
	static int T;
	static int N;
	static int map[][];
	static int bungi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int x = 0; x < N; x++) {
				char[] cc = br.readLine().toCharArray();
				for (int y = 0; y < N; y++) {
					map[x][y] = (int)(cc[y]-'0');
				}
			}
			int sum = 0;
			bungi = N/2 ;
			for (int a = 0; a < N; a++) {
				if(a<= bungi) {
					sum += map[a][bungi] + SideFarm(a,bungi,a,-1) + SideFarm(a,bungi,a,1);
				}
				else if(a>bungi) {
					sum += map[a][bungi] + SideFarm(a, bungi, N-a-1, -1) + SideFarm(a, bungi, N-a-1, 1);
				}
			}
			
			System.out.printf("#%d %d%n",i,sum);
			
			
		}
	}
	private static int SideFarm(int r, int c,int cnt, int dirc) {
		

		if(cnt == 0) {
			return 0;
		}
		else {
			return map[r][c+dirc] + SideFarm(r, c+dirc, cnt-1, dirc);
		}
	}
}
