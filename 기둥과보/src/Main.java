import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int [][]build_frame = {};
	}

	static boolean col[][];
	static boolean row[][];
	static int[][] solution(int n, int build_frame[][]){
		int [][]answer = {};
		
		col = new boolean [n+1][n+1];
		row = new boolean [n+1][n+1];
		
		int r = build_frame.length;
		int c = build_frame[0].length;
		
		for(int i = 0; i < r; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];
		}
		
		return answer;
	}
	static boolean insertCol(int r, int c, int n) {
		if(r == n) {
			col[r][c] = true;
			return true;
		}
		else {
			if(col[r+1][c]||row[r][c-1]||row[r][c]) {
				col[r][c] = true;
				return true;
			}
			return false;
		}
	}
	
	static boolean insertRow(int r, int c, int n) {
		if((row[r][c-1]&&row[r][c+1])||col[r+1][c]||col[r+1][c+1]) {
			row[r][c] = true;
			return true;
		}
		return false;
	}
	
	static boolean delete(int r, int c) {
		
		return false;
	}
	
}
