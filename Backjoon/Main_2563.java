import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563 {
	static int N;
	static int[][] map = new int[100][100];
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
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(map[r+i][c+j]==0) {
						map[r+i][c+j] = 1;
						cnt +=1;
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
}
