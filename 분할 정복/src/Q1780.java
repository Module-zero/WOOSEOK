/*
종이의 개수

https://www.acmicpc.net/problem/1780
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오후 2:59
 */

public class Q1780
{
    static int[] cnt = new int[3];
    static int[][] ary;

    public static void bs(int x, int y, int n)
    {
        if(isSame(x, y, n))
            cnt[ary[x][y] + 1]++;
        else
        {
            int m = n/3;

            for(int i=x; i<x+n; i+=m)
                for(int j=y; j<y+n; j+=m)
                    bs(i, j, m);
        }
    }

    public static boolean isSame(int x, int y, int n)
    {
        for(int i=x; i<x+n; i++)
        {
            for(int j=y; j<y+n; j++)
            {
                if(ary[x][y] != ary[i][j])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ary = new int[2200][2200];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        bs(0, 0, N);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt[0]).append("\n").append(cnt[1]).append("\n").append(cnt[2]).append("\n");

        System.out.print(sb.toString());
    }
}
