/*
차이를 최대로

https://www.acmicpc.net/problem/10819
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 7:48
 */

public class Q10819
{
    static int N;
    static int[] ary;
    static int[] tmp;
    static boolean[] check;
    static int max = Integer.MIN_VALUE;

    public static void foo(int index)
    {
        if(index == N)
        {
            int sum = 0;
            for(int i=0; i<N-1; i++)
            {
                int num = tmp[i] - tmp[i+1];
                if(num < 0)
                    num = -num;

                sum += num;
            }

            if(sum > max)
                max = sum;

            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i])
                continue;

            tmp[index] = ary[i];
            check[i] = true;
            foo(index+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        tmp = new int[N];
        check = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        foo(0);

        StringBuilder sb = new StringBuilder().append(max);
        System.out.println(sb.toString());
    }
}
