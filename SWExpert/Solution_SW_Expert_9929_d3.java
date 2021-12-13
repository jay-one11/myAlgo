import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_Expert_9929_d3 {
	
	static int T;
	static int N, M;
	static int snack[];
	static int max = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		

		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for (int n = 0; n < N; n++) {
				snack[n] = Integer.parseInt(st.nextToken());
			}
			subset(0,0,0);
			System.out.println("#"+t+" "+max);
			max = -1;
		}
	}

	private static void subset(int cnt, int tot,int select) {
		if(select == 2) {
			if(tot <= M) {
				max =Math.max(max, tot);
			}
			return;
		}
		else if(select >2 || cnt == N){
			return;
		}
		subset(cnt+1,tot+snack[cnt],select+1);
		subset(cnt+1,tot,select);
		
	}
	
	
}
