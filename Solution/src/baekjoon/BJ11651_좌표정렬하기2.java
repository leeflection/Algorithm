package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11651_좌표정렬하기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[2][n+1];
            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];
            for(int i=2; i<=n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.println(sb);
    }
}
