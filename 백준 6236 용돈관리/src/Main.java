import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int money[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		money = new int[N];
		
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		binarySearch();
	}
	
	static int answer = Integer.MAX_VALUE;
	
	static void binarySearch() {
		int left = 0;
		int right = 10000 * N;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(check(mid)) {
				if(answer > mid) answer = mid;
				right = mid -1;
			}
			else {
				left= mid + 1;
			}
		}
		System.out.println(answer);
	}
	
	static boolean check(int mid) {
		int result = 1;
		int left = mid;
		for(int i : money) {
			left -= i;
			if(left < 0) {
				if(i > mid) return false;
				else {
					result++;
					left = mid - i;
				}
			}
		}
		
		if(result <= M) return true;
		return false;
	}
}
