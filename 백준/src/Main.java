import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int A[];
	static int B[];
	static int C[];
	static int D[];
	static int aPlusB[];
	static int cPlusD[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		aPlusB = new int[N*N];
		cPlusD = new int[N*N];
	
		for(int i = 0; i < N; i++) {
			String t[] = br.readLine().split(" ");
			A[i] = Integer.parseInt(t[0]);
			B[i] = Integer.parseInt(t[1]);
			C[i] = Integer.parseInt(t[2]);
			D[i] = Integer.parseInt(t[3]);
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				aPlusB[cnt] = A[i]+B[j];
				cPlusD[cnt] = C[i]+D[j];
				cnt++;
			}
		}
		
		Arrays.sort(aPlusB);
		Arrays.sort(cPlusD);
		v = new int [N*N];
		nextRight =N*N-1;
	
		v[0] += binarySearch(aPlusB[0]);
		answer += (long) v[0];
		
		for(int i = 1; i < N*N; i++) {
			if(aPlusB[i]==aPlusB[i-1]) {
				v[i] = v[i-1];
			}
			else
				v[i] = binarySearch(aPlusB[i]);
			answer+=(long) v[i];
		}
		System.out.println(answer);
	}
	static int v[];
	static long answer = 0;
	static int nextRight;
	static int binarySearch(int n) {
		int left = 0;
		int right = nextRight;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int p = check(mid, n);
			if(p == 0) {
				nextRight = mid;
				return upperBound(mid,right, cPlusD[mid]) - lowerBound(left, mid-1, cPlusD[mid]);
			}
			else if(p < 0) {
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
		}
		return 0;
	}
	
	static int check(int mid, int n) {
		int res = cPlusD[mid] + n;
		return res;
	}
	
	static int lowerBound(int left, int right, int target) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(cPlusD[mid] < target) {
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
			if(cPlusD[mid] <= target) {
				left = mid + 1;
			}
			else {
				right = mid -1;
			}
		}
		return left;
	}
}