import java.util.Scanner;

public class Solution_4311_오래된스마트폰 {
	static int T;
	static int N,O,M,W;
	static int nums[];
	static int operation[];
	static int memo[];
	static boolean visited[];
	static int list[][];
	static char opop[] = {'0','+','-','*','/'};
	static int min = 0;
	static int length;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <=T; t++) {
			min = Integer.MAX_VALUE;
			memo = new int[1000];
			list = new int[1000][2];
			visited = new boolean[1000];
			length = 0;
			
			for (int i = 0; i < 1000; i++) {
				memo[i] = Integer.MAX_VALUE;
			}
			
			N = sc.nextInt();
			O = sc.nextInt();
			M = sc.nextInt();
			nums = new int[N];
			operation = new int[O];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			for (int i = 0; i < O; i++) {
				operation[i] = sc.nextInt();
			}
			
			W = sc.nextInt();
			
			for (int i = 1; i <=3; i++) {
				Perm(0,0,i);
			}
			
			for (int i = 0; i < O; i++) {
				for (int j = 0; j < length; j++) {
					solve(list[j][0],list[j][1],true);
				}
			}
			
			
			System.out.printf("#%d %d\n",t,min==Integer.MAX_VALUE?-1:min);
			
		}
	}
	private static void solve(int num, int cnt, boolean check) {
		if(num < 0 || num > 999) return;
		else if(cnt >= min) return;
		else if(cnt >= M ) return;
		else if(memo[num] <= cnt) return;
		memo[num] = cnt;
		if(num == W) {
//			System.out.println(num);
			if(visited[num]) {
				min = min > cnt ? cnt : min;
			}else {
				min = min > cnt ? cnt+1 : min;
			}
			return;
		}
		for (int i = 0; i < O; i++) {
			for (int j = 0; j < length; j++) {
				if(opop[operation[i]]=='+') {
					solve(num+list[j][0],cnt+1+list[j][1],false);
				}else if(opop[operation[i]]=='-') {
					solve(num-list[j][0],cnt+1+list[j][1],false);
				}else if(opop[operation[i]]=='*') {
					solve(num*list[j][0],cnt+1+list[j][1],false);
				}else if(opop[operation[i]]=='/' && list[j][0] != 0) {
					solve(num/list[j][0],cnt+1+list[j][1],false);
				}
			}
		}
	}
	private static void Perm(int cnt, int now, int L) {
		if(cnt == L) {
			if(visited[now]) return;
			visited[now] =true;
			list[length][0] = now;
			list[length++][1] = L;
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			Perm(cnt+1,now*10+nums[i],L);
		}
	}
	
}
