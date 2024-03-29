package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1520_내리막길 {
    static int[][] map;
    static int[][] dp;
    static int ans,N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(0,0,map[0][0]));

    }
    public static int dfs(int x, int y, int val){
        if(x == N-1 && y == M-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(map[nx][ny] < val){
                dp[x][y] += dfs(nx,ny,map[nx][ny]);
            }
        }
        return dp[x][y];
    }
}
