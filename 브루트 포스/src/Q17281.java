/*
⚾

https://www.acmicpc.net/problem/17281
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-30
 * Time: 오후 11:17
 */

public class Q17281
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[51][10];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int inning=0; inning<N; inning++)
        {
            
        }
    }
}
