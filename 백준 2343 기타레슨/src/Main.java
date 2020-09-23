import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int lesson[];
	static int max = 0;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lesson = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			if(lesson[i] > max) max = lesson[i];
		}
		binarySearch();
	}
	static int answer = Integer.MAX_VALUE;
	static void binarySearch() {
		int left = max;
		int right = N*10000;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(check(mid)) {
				if(mid < answer) answer = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int mid) {
		int num = 1;
		int sum = 0;
		for(int i: lesson) {
			sum += i;
			
			if(sum > mid) {
				sum = i;
				num++;
			}
		} 
		
		if(num <= M) {
			return true;
		}
		return false;
	}
}
