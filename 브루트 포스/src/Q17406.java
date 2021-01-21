/*
배열 돌리기 4

https://www.acmicpc.net/problem/17406
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-06
 * Time: 오전 11:49
 */

public class Q17406
{
    static int[][] ary = new int[51][51];
    static int N;
    static int M;
    static int K;
    static boolean[] check = new boolean[6];
    static int[] r = new int[6];
    static int[] c = new int[6];
    static int[] s = new int[6];
    static int[] order = new int[6];
    static int min = Integer.MAX_VALUE;

    public static void turn(int[][] ary, int r, int c, int s)
    {
        if(s == 0)
            return;

        int tmp = ary[r-s][c+s];
        for(int j=c+s; j>=c-s+1; j--)
            ary[r-s][j] = ary[r-s][j-1];

        int tmp2 = ary[r+s][c+s];
        for(int i=r+s; i>=r-s+2; i--)
            ary[i][c+s] = ary[i-1][c+s];
        ary[r-s+1][c+s] = tmp;

        tmp = ary[r+s][c-s];
        for(int j=c-s; j<=c+s-2; j++)
            ary[r+s][j] = ary[r+s][j+1];
        ary[r+s][c+s-1] = tmp2;

        for(int i=r-s; i<=r+s-2; i++)
            ary[i][c-s] = ary[i+1][c-s];
        ary[r+s-1][c-s] = tmp;

        turn(ary, r, c, s-1);
    }

    public static void foo(int index)
    {
        if(index == K)
        {
            int[][] map = new int[51][51];

            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=M; j++)
                    map[i][j] = ary[i][j];
            }

            for(int k=0; k<K; k++)
            {
                int id = order[k];

                turn(map, r[id], c[id], s[id]);
            }

            for(int i=1; i<=N; i++)
            {
                int sum = 0;
                for(int j=1; j<=M; j++)
                    sum += map[i][j];

                min = Integer.min(min, sum);
            }

            return;
        }

        for(int i=0; i<K; i++)
        {
            if(check[i])
                continue;

            check[i] = true;
            order[index] = i;
            foo(index+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());

            r[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
        }

        foo(0);

        System.out.println(min);
    }
}
