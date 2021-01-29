/*
숫자 정사각형

https://www.acmicpc.net/problem/1051
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 9:32
 */

public class Q1051
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[51][51];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        int lim = Integer.min(N, M);
        for(int size=lim-1; size>=0; size--)
        {
            for(int i=0; i+size<N; i++)
            {
                for(int j=0; j+size<M; j++)
                {
                    if(ary[i][j] == ary[i+size][j] && ary[i][j] == ary[i][j+size] && ary[i][j] == ary[i+size][j+size])
                    {
                        System.out.println((size+1)*(size+1));
                        return;
                    }
                }
            }
        }
    }
}
