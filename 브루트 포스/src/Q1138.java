/*
한 줄로 서기

https://www.acmicpc.net/problem/1138
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 10:23
 */

public class Q1138
{
    static int N;
    static boolean[] check = new boolean[11];
    static int[] order = new int[11];
    static int[] ans = new int[11];
    static StringBuffer sb = new StringBuffer();

    public static boolean foo(int index)
    {
        if(index == N+1)
        {
            for(int i=1; i<=N; i++)
            {
                int cnt = 0;
                for(int j=i-1; j>=1; j--)
                {
                    if(ans[j] > ans[i])
                        cnt++;
                }

                if(order[ans[i]] != cnt)
                    return false;
            }

            for(int i=1; i<=N; i++)
                sb.append(ans[i]).append(' ');

            return true;
        }

        for(int i=1; i<=N; i++)
        {
            if(!check[i])
            {
                check[i] = true;
                ans[index] = i;
                if(foo(index+1))
                    return true;

                check[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            order[i] = Integer.parseInt(st.nextToken());

        foo(1);

        System.out.println(sb.toString());
    }
}
