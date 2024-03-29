package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.*;

public class BJ1766_문제집 {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n+1];
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b]++;
            list[a].add(b);
        }
        topology(indegree);
    }

    private static void topology(int[] indegree) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->{
            return o1 - o2;
        });
        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");
            for(int i : list[cur]){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        System.out.println(sb);
    }
}
