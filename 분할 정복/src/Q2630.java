/*
색종이 만들기

https://www.acmicpc.net/problem/2630
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 5:46
 */

public class Q2630
{
    static int N;
    static int[][] ary = new int[128][128];
    static int[] cnt = new int[2];

    public static void foo(int left, int up, int size)
    {
        int val = ary[up][left];

        for(int i=up; i<up+size; i++)
        {
            for(int j=left; j<left+size; j++)
            {
                if(ary[i][j] != val)
                {
                    size /= 2;
                    foo(left, up, size);
                    foo(left+size, up, size);
                    foo(left, up+size, size);
                    foo(left+size, up+size, size);
                    return;
                }
            }
        }

        cnt[val]++;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0, N);
        StringBuffer sb = new StringBuffer();
        sb.append(cnt[0]).append('\n').append(cnt[1]);
        System.out.println(sb.toString());
    }
}
