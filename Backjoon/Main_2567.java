import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2567 {
	static int N;
	static int[][] map = new int[30][30];
	static int area ;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int r=0,c=0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(map[r][c] == 0) cnt +=1;
			if(map[r+10][c] == 0) cnt+=1;
			if(map[r][c+10] ==0) cnt +=1;
			if(map[r+10][c+10] == 0) cnt +=1;
			for (int i = 0; i < 10; i++) {
				cnt += SquareSize(r,c,i);
			}
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					if(map[r+i][c+j] == 1) cnt-=1;
					map[r+i][c+j] = 2;
				}
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < 30; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

	private static int SquareSize(int r, int c,int i) {
		int tot =0;
		if(map[r+i][c] == 0) { // 좌변
			tot +=1;
			map[r+i][c] = 1;
			}
		if(map[r][c+i] == 0) { // 상변
			tot+=1;
			map[r][c+i] = 1;
			}
		if(map[r+9][c+i] == 0) { // 하변
			tot+=1;
			map[r+9][c+i] =1;
		}
		if(map[r+i][c+9] == 0) { // 우변
			tot+=1;
			map[r+i][c+9] = 1;
		}
		return tot;
	}
	
	
	
}
