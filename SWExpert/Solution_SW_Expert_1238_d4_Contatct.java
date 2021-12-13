import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_Expert_1238_d4_Contatct {
	static int map[][];
	static int visited[];
	static int max = 101;
	static int mm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 2; t++) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int start = sc.nextInt();
			map = new int[max][max];
			visited = new int[max];
			for (int i = 0; i < (N-2)/2; i++) {
				int src = sc.nextInt();
				int dst = sc.nextInt();
				map[src][dst] = 1;
				mm = Math.max(mm, Math.max(src,dst));
			}
			
			Queue<Integer> contact = new LinkedList<>();
			contact.offer(start);
			visited[start] = 1;
			int idx = 1;
			while(!contact.isEmpty()) {
				// que에서 꺼낸다
				int node = contact.poll();
				// 인접 node를 찾는다
				// 방문했는지 확인 후, 방문했으면 pass, 방문 안했으면 que에 offer
				for (int i = 0; i < mm; i++) {
					if(map[node][i] == 1 && visited[i] == 0) {
						contact.offer(i);
						visited[i] = visited[node]+1;
						idx = visited[i];
					}
				}
			}
			int Max=0;
			for (int i = 0; i < mm; i++) {
				if(visited[i] == idx) {
					Max = Math.max(i, Max);
				}
			}
			System.out.println("#"+t+" "+Max);
		}

	}
}
