import java.util.Scanner;

public class Main_2564_경비원 {
	static int W,H;
	static int N;
	static int map[][];
	static int store[];
	static int dirction[]= {1,4,2,3};
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 W = sc.nextInt();
		 H = sc.nextInt();
		 N= sc.nextInt();
		 map = new int[H+1][W+1];
		 store = new int[N];
		 for (int i = 1; i <= N; i++) {
			int d = sc.nextInt();
			int k = sc.nextInt();
			store[i-1] = d;
			if(d == 1) {
//				북쪽
				map[0][k] = i;
			}else if (d==2) {
//				남쪽
				map[H][k] = i;
			}else if(d==3) {
//				서쪽
				map[k][0] = i;
			}else if(d==4) {
//				동쪽
				map[k][W] = i;
			}
		}
//		 동근이
			int d = sc.nextInt();
			int k = sc.nextInt();
			int r = 0;
			int c = 0;
			if(d == 1) {
//				북쪽
				r = 0;
				c = k;
			}else if (d==2) {
//				남쪽
				r=H; c=k;
//				store[H][k] = 101;
			}else if(d==3) {
//				서쪽
				r=k;c=0;
//				store[k][0] = 101;
			}else if(d==4) {
//				동쪽
				r=k;c=W;
//				store[k][W] = 101;
			}
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				int distance = explore(r,c,i);
				sum += distance;
			}
			System.out.println(sum);

	}
	private static int explore(int r, int c, int i) {
		return Math.min(FIND(r,c,-1,i), FIND(r, c, 1, i));
	}
	private static int FIND(int r, int c,int dirc, int num) {
//		dirc 1 >> 시계, -1 >> 반시계
		int cnt = 0;
		while(true) {
			if(map[r][c] == num) {
				break;
			}
//			북쪽
			cnt +=1;

			if(r==0) {
				if(dirc == 1) {
					c +=1;
					if(c == W) {
						r +=1;
						cnt +=1;

					}
				}
				else if(dirc == -1){
					c -=1;
					if(c== 0) {
						r +=1;
						cnt +=1;

					}
				}
//			남쪽
			}else if(r==H) {
				if(dirc == 1) {
					c-=1;
					if(c==0) {
						r-=1;
						cnt +=1;

					}
				}
				else if(dirc == -1){
					c+=1;
					if(c==W) {
						r-=1;
						cnt +=1;

					}
				}
//				서쪽
			}else if(c==0) {
				if(dirc == 1) {
					r -=1;
					if(r==0) {
						c+=1;
						cnt +=1;

					}
				}
				else if(dirc == -1){
					r+=1;
					if(r==H) {
						c+=1;
						cnt +=1;

					}
				}
//				동쪽
			}else if(c==W) {
				if(dirc == 1) {
					r+=1;
					if(r==H) {
						c-=1;
						cnt +=1;

					}
				}
				else if(dirc == -1){
					r-=1;
					if(r==0) {
						c-=1;
						cnt +=1;

					}
				}
			}else {
				System.out.println("??");
			}
		}
		return cnt;
		
	}
}
