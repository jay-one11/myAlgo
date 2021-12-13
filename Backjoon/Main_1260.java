import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS {
	static int N;
	static int M;
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;

		}
	}
	static Node[] adjacent;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		adjacent = new Node[N+1];
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			
			
			// 작은 순서대로 정렬하기...
			Node newNode = new Node(dst,null);
			Node head = adjacent[src];
			Node cur = head;
			while(true) {
				if (head == null) {
					adjacent[src] = newNode;
					break;
				}
				else if(cur.next == null) {
					cur.next = newNode;
					break;
				}
				else if(cur.vertex>newNode.vertex ) {
					newNode.next = cur;
					if(cur == adjacent[src]) {
						adjacent[src] = newNode;
					}
					break;
				}

				cur = cur.next;

			}
			
			newNode = new Node(src,null);
			head = adjacent[dst];
			cur = head;
			while(true) {
				if (head == null) {
					adjacent[dst] = newNode;
					break;
				}
				else if(cur.vertex>newNode.vertex ) {
					newNode.next = cur;
					if(cur == adjacent[dst]) {
						adjacent[dst] = newNode;
					}
					break;
				}
				else if(cur.next == null) {
					cur.next = newNode;
					break;
				}

				cur = cur.next;

			}
			
			
		}
		DFS(start,new boolean[N+1]);
		System.out.println();
		BFS(start);
		System.out.println();
	}
	private static void BFS(int start) {
		boolean v[] = new boolean[N+1];
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		v[start] = true;
		while(!que.isEmpty()) {
			int current = que.poll();
			System.out.print(current+" ");
			for (Node tmp = adjacent[current]; tmp != null; tmp = tmp.next) {
				if(!v[tmp.vertex]) {
					v[tmp.vertex] = true;
					que.offer(tmp.vertex);
				}
			}
		}
		
		
	}
	private static void DFS(int current, boolean[] v) {
		v[current] = true;
		System.out.print(current+" ");
		for (Node tmp = adjacent[current]; tmp != null ; tmp = tmp.next) {
			if(!v[tmp.vertex]) {
				DFS(tmp.vertex,v);
			}
		}
		
	}
}
