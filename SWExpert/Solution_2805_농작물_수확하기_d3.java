import java.util.Scanner;

public class Solution_2805_농작물_수확하기_d3 {
	static int T;
	static int N;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <=T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char cc[] = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = cc[j]-'0';
				}
			}
			int K = N/2;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += map[i][K];
				if(i<=K) {
					for (int j = 1; j <= i ; j++) {
						sum += map[i][K-j];
						sum += map[i][K+j];
					}

				}
				else {
					for (int j = 1; j < N-i; j++) {
						sum += map[i][K-j];
						sum += map[i][K+j];
					}
				}
			}
			
			System.out.printf("#%d %d%n",t,sum);
		}
		
	}
}
