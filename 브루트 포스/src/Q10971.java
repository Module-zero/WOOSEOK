/*
외판원 순회 2

https://www.acmicpc.net/problem/10971
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 8:05
 */

public class Q10971
{
    static int N;
    static boolean[] check;
    static int[][] W;
    static int min = Integer.MAX_VALUE;

    public static void foo(int index, int sum, int prev)
    {
        if(index == N-1)
        {
            if(W[prev][0] == 0)
                return;

            sum += W[prev][0];

            if(min > sum)
                min = sum;

            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i] || W[prev][i] == 0)
                continue;

            check[i] = true;
            foo(index+1, sum + W[prev][i], i);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        check = new boolean[N];
        W = new int[N][N];

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        check[0] = true;
        foo(0, 0, 0);

        System.out.println(min);
    }
}
