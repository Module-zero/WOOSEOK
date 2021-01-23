/*
경로 찾기

https://www.acmicpc.net/problem/11403
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 1:16
 */

public class Q11403
{
    static int[][] ary = new int[101][101];
    static int[][] ans = new int[101][101];
    static boolean[] check;
    static int N;

    public static void dfs(int start, int cur)
    {
        ans[start][cur] = 1;

        check[cur] = true;

        for(int i=1; i<=N; i++)
        {
            if(ary[cur][i] == 1 && !check[i])
                dfs(start, i);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++)
        {
            check = new boolean[101];
            for(int j=1; j<=N; j++)
            {
                if(i == j)
                    continue;

                if(ary[i][j] == 1)
                    dfs(i, j);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
                sb.append(ans[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
