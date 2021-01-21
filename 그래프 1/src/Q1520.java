/*
내리막길

https://www.acmicpc.net/problem/1520
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-06
 * Time: 오후 4:55
 */

public class Q1520
{
    static int N;
    static int M;
    static int[][] ary = new int[501][501];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] d = new int[501][501];

    public static int dfs(int r, int c)
    {
        if(r == 0 && c == 0)
            d[r][c] = 1;

        if(d[r][c] != -1)
            return d[r][c];

        d[r][c] = 0;
        for(int i=0; i<4; i++)
        {
            int newR = r + dr[i];
            if(newR < 0 || newR >= M)
                continue;

            int newC = c + dc[i];
            if(newC < 0 || newC >= N)
                continue;

            // 낮은 숫자로만 갈 수 있음
            if(ary[newR][newC] <= ary[r][c])
                continue;

            d[r][c] += dfs(newR, newC);
        }

        return d[r][c];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
                d[i][j] = -1;
        }

        dfs(M-1, N-1);

        System.out.println(d[M-1][N-1]);
    }
}
