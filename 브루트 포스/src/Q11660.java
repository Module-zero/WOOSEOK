/*
구간 합 구하기 5

https://www.acmicpc.net/problem/11660
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 3:53
 */

public class Q11660
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1025][1025];
        int[][] ps = new int[1025][1025];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(j == 1)
                    ps[i][j] = ps[i-1][N] + ary[i][j];
                else
                    ps[i][j] = ps[i][j-1] + ary[i][j];
            }
        }

        StringBuffer sb = new StringBuffer();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int x=x1; x<=x2; x++)
            {
                if(y1 == 1)
                    sum += ps[x][y2] - ps[x-1][N];
                else
                    sum += ps[x][y2] - ps[x][y1 - 1];
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}
