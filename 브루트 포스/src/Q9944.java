/*
NxM 보드 완주하기

https://www.acmicpc.net/problem/9944
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-20
 * Time: 오후 3:31
 */

public class Q9944
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String value = br.readLine();
            if(value == null)
                break;

            StringTokenizer st = new StringTokenizer(value);

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][] ary = new char[31][31];
            for(int i=0; i<N; i++)
            {
                String str = br.readLine();

                for(int j=0; j<M; j++)
                    ary[i][j] = str.charAt(j);
            }

            int min = Integer.MAX_VALUE;
            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(ary[i][j] == '.')
                    {
                        int cnt = 0;


                    }
                }
            }
        }
    }
}
