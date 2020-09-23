import java.util.*;
import java.time.*;
class Edge{
	Edge(int v1, int v2){
		this.v1 = v1;
		this.v2 = v2;
	}
	int v1, v2;
	int cost = 1;
}

public class Main {
	static int T,N,M;
	static int level[];
	static int parent[];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for(int idx = 0; idx < T; idx++) {
			N = scan.nextInt();
			M = scan.nextInt();
			level = new int [N+1];
			parent = new int [N+1];
			
			for(int i = 1; i < N+1; i++) {
				level[i] = 1;
				parent[i] = i;
			}
			
			Edge edges[] = new Edge [M];
			for(int i = 0; i < M; i++) {
				edges[i] = new Edge(scan.nextInt(), scan.nextInt());
			}
			
			int ans = 0;
			for(int i = 0; i < M; i++) {
				int v1 = edges[i].v1;
				int v2 = edges[i].v2;
				if(find(v1) == find(v2)) {
					continue;
				}
				else {
					union(v1,v2);
					ans++;
				}
			}
			
			System.out.println(ans);
			
		}
	}
	static int find(int u) {
		if(u == parent[u])
			return u;
		else 
			return parent[u] = find(parent[u]);
	}
	
	static void union(int x, int y){
		  x = find(x);
		  y = find(y);
		  
		  if (x == y)
		    return;
		  
		  if (level[x] > level[y]){
		    parent[y] = x;
		    level[x] += level[y];
		  }
		  else {
		    parent[x] = y;
		    level[y] += level[x];
		  }
		}
}

