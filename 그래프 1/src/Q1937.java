/*
욕심쟁이 판다

https://www.acmicpc.net/problem/1937
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-25
 * Time: 오후 9:31
 */

public class Q1937
{
    static int n;
    static int[][] ary = new int[501][501];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] dist = new int[501][501];
    static int ans = 0;

    public static void dfs(int r, int c)
    {
        // 이미 들른 적이 있는 칸
        if(dist[r][c] > 0)
            return;

        dist[r][c] = 1;
        for(int k=0; k<4; k++)
        {
            int newR = r + dr[k];
            if(newR < 0 || newR >= n)
                continue;

            int newC = c + dc[k];
            if(newC < 0 || newC >= n)
                continue;

            // 대나무가 더 적으면 가지 않음
            if(ary[newR][newC] <= ary[r][c])
                continue;

            // 아직 가지 않은 칸이면 간다.
            if(dist[newR][newC] == 0)
                dfs(newR, newC);

            dist[r][c] = Integer.max(dist[r][c], dist[newR][newC] + 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(dist[i][j] == 0)
                    dfs(i, j);

                ans = Integer.max(ans, dist[i][j]);
            }
        }

        System.out.println(ans);
    }
}
