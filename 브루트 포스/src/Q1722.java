/*
순열의 순서

https://www.acmicpc.net/problem/1722
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 7:07
 */

public class Q1722
{
    static int N;
    static boolean[] check = new boolean[21];
    static int[] ary = new int[21];

    public static void foo(long rem, long order, int id)
    {
        if(id == N)
            return;

        int divisor = N - id;
        rem /= divisor;

        // 몇 번째 수인지
        for(int i=1; i<=divisor; i++)
        {
            if(order <= rem * i)
            {
                int cnt = 1;

                for(int k=1; k<=N; k++)
                {
                    if(check[k])
                        continue;

                    if(cnt == i)
                    {
                        ary[id] = k;
                        check[k] = true;
                        foo(rem, order-(rem * (i-1)), id+1);
                        break;
                    }

                    cnt++;
                }

                break;
            }
        }
    }

    public static long goo(long rem, int id)
    {
        if(id == N)
            return 1;

        int divisor = N - id;
        rem /= divisor;

        int target = ary[id];
        int cnt = 0;
        for(int i=1; i<=N; i++)
        {
            if(check[i])
                continue;

            if(target == i)
            {
                check[target] = true;
                return (rem * cnt) + goo(rem, id + 1);
            }

            cnt++;
        }

        return 1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        if(num == 1)
        {
            long k = Long.parseLong(st.nextToken());

            long rem = 1;
            for(int i=2; i<=N; i++)
                rem *= i;

            foo(rem, k, 0);

            StringBuffer sb = new StringBuffer();
            for(int i=0; i<N; i++)
                sb.append(ary[i]).append(' ');

            System.out.println(sb.toString());
        }
        else if(num == 2)
        {
            for(int i=0; i<N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            long rem = 1;
            for(int i=2; i<=N; i++)
                rem *= i;

            System.out.println(goo(rem, 0));
        }
    }
}
