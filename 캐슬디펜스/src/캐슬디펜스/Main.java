//package 캐슬디펜스;
import java.util.*;
class Archer{
	Archer(){}
	int col;
	LinkedList <Dist>distance = new LinkedList<>();
}
class Dist implements Comparable{
	Dist(int idx, int dist, int pos[]){
		this.idx =  idx;
		this.dist = dist;
		this.pos = pos;
	}
	int idx;
	int dist;
	int pos[];
	
	@Override
	public int compareTo(Object obj) {
		Dist d = (Dist) obj;
		if(this.dist < d.dist) {
			return -1;
		}
		else if(this.dist > d.dist) {
			return 1;
		}
		else {
			if(this.pos[1]<d.pos[1]) {
				return -1;
			}
			else if(this.pos[1]>d.pos[1]) {
				return 1;
			}
			else
				return 0;
		}
	}
}

public class Main {
	static ArrayList <int[]>Enemies = new ArrayList<>();
	static int R, C, D;
	static boolean V[];
	static boolean Killed[];
	
 	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		D = scan.nextInt();
		V = new boolean[C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int e = scan.nextInt();
				if(e == 1) {
					int arr [] = {i,j};
					Enemies.add(arr);
				}
			}
		}
		
		comb(0,0);
		System.out.println(Max);
	}
 	
 	static int getDistance(int e[], int col) {
 		return (int) (Math.abs(e[0]-R)+Math.abs(e[1]-col));
 	}
 	
 	static int Kill(Archer a[]) {
 		int score = 0;
 		Killed = new boolean[Enemies.size()];
 		int range = D;
 		for(int j = R-1; j >= 0; j--) {
 			for(int i = 0; i < 3; i++) {
 				if(!a[i].distance.isEmpty()) {
 					Dist d = a[i].distance.peek();
 					if(d.dist <= range) {
 						Killed[d.idx] = true;
 						a[i].distance.pop();
 					}
 					
 					for(int k = 0; k < a[i].distance.size(); k++) {
 						if(a[i].distance.get(k).pos[0]==j) {
 							a[i].distance.remove(k);
 							k--;
 						}
 						else {
 							a[i].distance.get(k).dist--;
 						}
 					}
 				}
 	 		}
 			for(int i = 0; i < 3; i++) {
 				for(int k = 0; k < a[i].distance.size(); k++) {
 					if(Killed[a[i].distance.get(k).idx]) {
 						a[i].distance.remove(k);
 						k--;
 					}
 				}
 			}
		}
 		
 		for(int i = 0; i < Killed.length; i++) {
 			if(Killed[i]) score++;
 		}
 		return score;
 	}
 	static int Max = Integer.MIN_VALUE;
 	
 	static void comb(int step, int start) {
 		if(step == 3) {
 			Archer []archers = new Archer[3];
 			int cnt = 0;
 			for(int i = 0; i < C; i++) {
 				if(V[i]) {
 					archers[cnt] = new Archer();
 					archers[cnt].col = i;
 					for(int j = 0; j < Enemies.size(); j++) {
 						int pos[] = Enemies.get(j);
 		 				archers[cnt].distance.add(new Dist(j,getDistance(pos,i),pos));
 		 			}
 					Collections.sort(archers[cnt].distance);
 					cnt++;
 				}
 			}
 			int cur = Kill(archers);
 			if(cur > Max) Max = cur;
 			
 			return;
 		}
 		
 		for(int i = start; i < C; i++) {
 			if(!V[i]) {
 				V[i] = true;
 				comb(step+1, i+1);
 				V[i] = false;
 			}
 		}
 	}
}
