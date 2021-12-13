import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_Expert_5215_d3 {
	static int T;
	static int N,KAL;
	static int ingred[][];
	static int max = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			KAL = Integer.parseInt(st.nextToken());
			ingred = new int[N][2];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine()," ");
				ingred[n][0] = Integer.parseInt(st.nextToken()); // taste
				ingred[n][1] = Integer.parseInt(st.nextToken()); // cal
			}
			subset(0,0,0);
			System.out.println("#"+i+" "+max);
			max = -1;
		}

	}
	
	public static void subset(int cnt, int taste, int cal) {
		if(cnt == N) {
			if(cal > KAL) {
				return;
			}
			max = Math.max(max, taste);
			return;
		}
		if(cal > KAL) {
			return;
		}
		max = Math.max(max, taste);
		subset(cnt+1, taste+ingred[cnt][0], cal+ingred[cnt][1]);
		subset(cnt+1, taste,cal);

	}
	
	
	
}
