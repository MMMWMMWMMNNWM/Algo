import java.io.*;
import java.util.*;
class Node {
	
	Node(int x, int y, int z, int id){
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}
	
	int x,y,z,id;
}

class Edge implements Comparable{
	Edge(int u, int v, int c){
		this.u = u;
		this.v = v;
		this.c = c;
	}
	int u,v,c;
	@Override
	public int compareTo(Object o) {
		Edge e = (Edge) o;
		return this.c - e.c;
	}
}

public class Main {
	static int N;
	static int parent[], level[];
	static ArrayList <Node> Nodes = new ArrayList<>();
	static PriorityQueue <Edge> pq = new PriorityQueue<>();

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int [N];
		level = new int [N];
		for(int i = 0; i < N ; i++) {
			parent[i] = i;
			level[i] = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Nodes.add(new Node(x,y,z,i));
		}
		sort();

		long answer = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(union(cur.u,cur.v)) {
				answer += cur.c;
			}
		}
		System.out.println(answer);
		
	}
	static void sort() {
		Collections.sort(Nodes, new Comparator<Node>(){
			public int compare(Node u, Node v) {
				return u.x - v.x;
			}
		});
		for(int i = 0; i < N-1; i++) {
			int u = Nodes.get(i).id;
			int v = Nodes.get(i+1).id;
			int c = Math.abs(Nodes.get(i).x -Nodes.get(i+1).x);
			pq.add(new Edge(u,v,c));
		}
		
		Collections.sort(Nodes, new Comparator<Node>(){
			public int compare(Node u, Node v) {
				return u.y - v.y;
			}
		});
		for(int i = 0; i < N-1; i++) {
			int u = Nodes.get(i).id;
			int v = Nodes.get(i+1).id;
			int c = Math.abs(Nodes.get(i).y -Nodes.get(i+1).y);
			pq.add(new Edge(u,v,c));
		}
		
		Collections.sort(Nodes, new Comparator<Node>(){
			public int compare(Node u, Node v) {
				return u.z - v.z;
			}
		});
		for(int i = 0; i < N-1; i++) {
			int u = Nodes.get(i).id;
			int v = Nodes.get(i+1).id;
			int c = Math.abs(Nodes.get(i).z -Nodes.get(i+1).z);
			pq.add(new Edge(u,v,c));
		}
	}
	
	static int find(int u) {
		if(u == parent[u])
			return u;
		
		return parent[u] = find(parent[u]);
	}
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) return false;
		
		if(level[v] < level[u]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] = v;
		if(level[u] == level[v]) 
			level[v]++;
		
		return true; 
 	}
}
