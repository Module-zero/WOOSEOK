/*
배열에서 이동

https://www.acmicpc.net/problem/1981
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-07
 * Time: 오후 10:28
 */

public class Q1981
{
    static int n;
    static int[][] ary = new int[101][101];
    static boolean[][] check;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static int dfs(int r, int c, int max, int min)
    {
        if(check[r][c])
            return -1;

        check[r][c] = true;
        // (n, n)에 도착했으면 true
        if(r == n-1 && c == n-1)
            return max - min;

        for(int i=0; i<4; i++)
        {
            int newR = r + dr[i];
            if(newR < 0 || newR >= n)
                continue;
            int newC = c + dc[i];
            if(newC < 0 || newC >= n)
                continue;

            if(check[newR][newC])
                continue;

            max = Integer.max(ary[newR][newC], max);
            min = Integer.min(ary[newR][newC], min);

            int ret = dfs(newR, newC, max, min);
            if(ret >= 0)
                return ret;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ary = new int[101][101];

        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 200;
        int min = Integer.MAX_VALUE;

        while(start <= end)
        {
            int mid = (start + end) / 2;
            check = new boolean[100][100];

            int ret = dfs(0, 0, ary[0][0], ary[0][0]);
            if(ret >= mid)
            {
                min = Integer.min(mid, min);

                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        System.out.println(min);
    }
}
