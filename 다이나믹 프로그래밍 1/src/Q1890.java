/*
점프

https://www.acmicpc.net/problem/1890
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 11:26
 */

public class Q1890
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[101][101];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        long[][] d = new long[101][101];
        d[0][0] = 1;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                int rem = ary[i][j];
                if(rem == 0)
                    continue;

                for(int k=0; k<2; k++)
                {
                    int newR = i + dr[k]*rem;
                    if(newR >= N)
                        continue;
                    int newC = j + dc[k]*rem;
                    if(newC >= N)
                        continue;

                    d[newR][newC] += d[i][j];
                }
            }
        }

        System.out.println(d[N-1][N-1]);
    }
}
