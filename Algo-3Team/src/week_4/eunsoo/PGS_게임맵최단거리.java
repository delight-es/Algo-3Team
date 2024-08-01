package week_4.eunsoo;

import java.io.*;
import java.util.*;

/* 게임 맵 최단거리
 * [입력] maps: (n,m) 지도 2차원배열 (0-벽, 1-길)
 * [출력] (0,0) ~ (n,m) 최단경로
 * - 도착 못할 경우 -1
 */

public class PGS_게임맵최단거리 {
	//상우하좌
		static int N,M;
		static int[] di = {-1,0,1,0}, dj= {0,1,0,-1};
		static int[][] arr;
		static boolean[][] v;
		
		static void bfs(int i, int j) {
			ArrayDeque<int[]> q = new ArrayDeque<>();
			v[i][j] = true;
			q.offer(new int[] {i,j});
			while(!q.isEmpty()) {
				int[] ij = q.poll();
				i = ij[0];
				j = ij[1];
				//처리
				for(int d=0; d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj] && arr[ni][nj] == 1) {
						v[ni][nj] = true;
						arr[ni][nj] = arr[i][j]+1; 
						q.offer(new int[] {ni,nj});
					}
				}
			}
		}
	    
	     public static int solution(int[][] nums) {
		 	int answer = 0;
		 	N = nums.length;
		 	M = nums[0].length;
		 	arr = nums;
		 	v = new boolean[N][M];

		 	bfs(0,0);
	        answer = nums[N-1][M-1]==1? -1:nums[N-1][M-1];
	        return answer;
	    }
	     
	    public static void main(String[] args) {
			int answer = solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
			System.out.println(answer);
		}
}
