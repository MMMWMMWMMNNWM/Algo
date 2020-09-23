import java.io.*;
import java.util.*;

class Point implements Comparable{
	Point(int x, int y){
		this.x = x;
		this.y = y;
	} 
	int x, y;
	int step;
	@Override
	public int compareTo(Object obj) {
		Point p = (Point) obj;
		return this.x - p.x;
	}
}

public class Main {
	static int n, T;
	static Point[] p;
	static boolean v[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		p = new Point [n+1];
		v = new boolean [n+1];
		p[0] = new Point(0,0);
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new Point(x,y);
		}
		
		Arrays.sort(p);
		for(Point p1:p)
			System.out.print(p1.x+" ");
		System.out.println();
	}
	static void bfs() {
		Queue <Point> q = new LinkedList<>();
		Queue <Integer> idx = new LinkedList<>();
		idx.add(0);
		q.add(p[0]);
		v[0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				Point cur = q.poll();
				int curIdx = idx.poll();
				getRange(cur.x, curIdx);
			}
		}
	}
	
	static int Left = 0;
	static int Right = 0;
	
	static void getRange(int curXpos, int idx) {
		int left = curXpos - 2;
		int right = curXpos + 2;
		lowerBound(0,idx-1,left);
		upperBound(idx,n,right);
	}
	
	static int lowerBound(int left, int right, int target) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(p[mid].x < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}
	static int upperBound(int left, int right, int target) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(p[mid].x <= target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return left;
	}
}
