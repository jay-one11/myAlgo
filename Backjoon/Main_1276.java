import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1276_게리맨더링 {
	static int N,min;
	static int population[];
	static boolean goo[];
	static ArrayList<Integer> list[]= null;
	public static void main(String[] args) {
		min = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		population = new int[N+1];
		list = new ArrayList[N+1];
		goo = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			int t = sc.nextInt();
			for (int j = 0; j < t; j++) {
				list[i].add(sc.nextInt());
			}
		}
		
		subset(1);
		
		int resut = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println(resut);
		sc.close();
	}
	private static void subset(int cnt) {
		if (cnt == N +1) {
			if(check()) {
				int Apop = 0,Bpop = 0;
				for (int i = 1; i <= N; i++) {
					if(goo[i]) Apop += population[i];
					else Bpop += population[i];
				}
				min = Math.min(min, Math.abs(Apop-Bpop));
			}
			return;
		}
		
		goo[cnt] = true;
		subset(cnt+1);
		goo[cnt] = false;
		subset(cnt+1);
		
	}
	private static boolean check() {
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visited = new boolean [N+1];
		int src_A = 0, src_B = 0;
		for (int i = 1; i <= N; i++) {
			if (goo[i]) {
				src_A = i;
				break;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(!goo[i]) {
				src_B= i;
				break;
			}
		}
		
		if(src_A == 0 || src_B == 0) {
			return false;
		}
		
//		A구 탐색
		que.offer(src_A);
		visited[src_A] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 0; i < list[cur].size(); i++) { //cur과 연결된 Node중에
				int next = list[cur].get(i);
				if(!visited[next] && goo[next]) { // 방문하지 않았으면서 A구
					que.offer(next);
					visited[next] = true;
				}
			}
		}
		
//		B구 탐색
		que.offer(src_B);
		visited[src_B] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(!visited[next] && !goo[next]) {
					que.offer(next);
					visited[next] = true;
				}
			}
		}
		
//		모든 구가 A 또는 B에 속해있는지?
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		return true;
		
	}
}
