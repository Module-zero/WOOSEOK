/*
행렬

https://www.acmicpc.net/problem/1080
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 7:24
 */

public class Q1080
{
    static int[][] A = new int[50][50];
    static int ans = 0;
    static int N;
    static int M;

    public static void reverse(int a, int b)
    {
        for(int i=a; i<a+3; i++)
        {
            for (int j = b; j < b + 3; j++)
                A[i][j] = 1 - A[i][j];
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                A[i][j] = str.charAt(j) - '0';
        }

        int[][] B = new int[50][50];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                B[i][j] = str.charAt(j) - '0';
        }

        for(int i=0; i<N-2; i++)
        {
            for(int j=0; j<M-2; j++)
            {
                if(A[i][j] != B[i][j])
                {
                    reverse(i, j);
                    ans++;
                }
            }
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(A[i][j] != B[i][j])
                {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}
