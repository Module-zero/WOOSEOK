/*
종이 조각

https://www.acmicpc.net/problem/14391
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오전 2:01
 */

public class Q14391
{
    static int N;
    static int M;
    static int[][] ary = new int[4][4];
//    static int[][] vOrH  = new int[4][4];
//    static int max = 0;

/*
    public static void foo(int i, int j)
    {
        if(j >= M)
        {
            foo(i + 1, 0);
            return;
        }

        if(i >= N)
        {
            int sum = 0;

            for(int r=0; r<N; r++)
            {
                int cur = 0;
                for(int c=0; c<M; c++)
                {
                    if(vOrH[r][c] == 0)
                        cur = 10*cur + ary[r][c];
                    else
                    {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            for(int c=0; c<M; c++)
            {
                int cur = 0;
                for(int r=0; r<N; r++)
                {
                    if(vOrH[r][c] == 1)
                        cur = 10*cur + ary[r][c];
                    else
                    {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            if(max < sum)
                max = sum;

            return;
        }

        // 가로
        vOrH[i][j] = 0;
        foo(i, j+1);
        // 세로
        vOrH[i][j] = 1;
        foo(i, j+1);
    }
*/

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
                ary[i][j] = str.charAt(j) - '0';
        }

//        foo(0, 0);

        int max = 0;

        // 0 ~ 2^NM-1
        int size = (2 << N*M);
        for(int bit=0; bit < size; bit++)
        {
            int sum = 0;

            for(int i=0; i<N; i++)
            {
                int cur = 0;

                for(int j=0; j<M; j++)
                {
                    int k = i*M + j;

                    if((bit & (1 << k)) == 0)
                        cur = 10*cur + ary[i][j];
                    else
                    {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            for(int j=0; j<M; j++)
            {
                int cur = 0;

                for(int i=0; i<N; i++)
                {
                    int k = i*M + j;

                    if((bit & (1 << k)) != 0)
                        cur = 10*cur + ary[i][j];
                    else
                    {
                        sum += cur;
                        cur = 0;
                    }
                }

                sum += cur;
            }

            if(max < sum)
                max = sum;
        }

        System.out.println(max);
    }
}
