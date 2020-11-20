/*
파이프 옮기기 2

https://www.acmicpc.net/problem/17069
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-20
 * Time: 오후 8:46
 */

public class Q17069
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[33][33];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        long[][] hor = new long[33][33];
        long[][] ver = new long[33][33];
        long[][] dia = new long[33][33];

        hor[1][2] = 1;
        for(int i=1; i<=N; i++)
        {
            for(int j=3; j<=N; j++)
            {
                if(ary[i][j] == 1)
                {
                    hor[i][j] = 0;
                    ver[i][j] = 0;
                    dia[i][j] = 0;
                    continue;
                }

                hor[i][j] = hor[i][j - 1] + dia[i][j - 1];
                ver[i][j] = ver[i - 1][j] + dia[i - 1][j];

                // 대각선은 위와 왼쪽도 벽이 아니어야만 가능
                if(ary[i-1][j] != 1 && ary[i][j-1] != 1)
                    dia[i][j] = dia[i - 1][j - 1] + hor[i - 1][j - 1] + ver[i - 1][j - 1];
            }
        }

        System.out.println(hor[N][N] + ver[N][N] + dia[N][N]);
    }
}
