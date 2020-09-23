import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		int []cards = {12, 7, 11, 6, 2, 12};
		System.out.println(solution(cards));
	}
	static int n;
	public static int solution(int[] cards) {
        int answer = 0;
        
        while(true) {
        	blackJack(fin+1, cards);
        	if(fin >= cards.length -1)
        		break;
        }
        answer = money;
        return answer;
    }
	static int money = 0;
	static int fin = -1;
	static void blackJack(int s,int cards[]) {
		int p[] = new int[14];
		int d[] = new int[14];
		int pp = 0;
		int dd = 0;
		boolean pStop = false;
		boolean dStop = false;
		if(s+4 >= cards.length) {
			fin = cards.length;
			return;
		}

		int open = cards[s+3];
		for(int i = s; i < s+4; i++) {
			if(cards[i]>=10) cards[i] =10;
			if(i%2 == 0) {
				p[cards[i]]++;
			}
			else {
				d[cards[i]]++;
			}
			fin = i;
		}
		
		if(p[1]>0&&p[10]>0) {
			if(d[1]>0&&d[10]>0) {
				return;
			}
			money+=3;
			return;
		}

		for(int j = 2; j <= 10; j++) {
			pp += p[j]*j;
		}

		for(int i = s+4; i <cards.length; i++) {
			fin = i;
			if(!pStop) {
				if(open == 1 || open >= 7) {
					if(p[1]>0) {
						if(pp+11>=17 && pp+17 <= 21) {
							pp = pp+11;
							pStop = true;
							p[1]--;
							p[11]++;
						}
						else {
							pp+=cards[i];
							if(pp+11>=17 && pp+11 <= 21) {
								pp = pp+11;
								pStop = true;
								p[1]--;
								p[11]++;
							}
							else {
								pp+=1;
								if(pp>=17 && pp<= 21) {
									pStop = true;
								if(pp>21) {
									money -=2;
									return;
								}
							}
						}
					}
				}
				else if(open >=4 && open <= 6){
					
				}
				else {
					if(p[1]>0) {
						pStop = true;
					}
					else {
						if(pp>=12) {
							pStop = true;
						}
						else {
							pp+= cards[i];
						}
					}
				}
			}
			
		}
	}
}
