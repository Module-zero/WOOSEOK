/*
연산자 끼워넣기(2)

https://www.acmicpc.net/problem/15658
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 5:41
 */

public class Q15658
{
    static int N;
    static int[] A = new int[12];
    static int[] cnt = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void foo(int index, int sum, int plus, int minus, int mul, int div)
    {
        if(index == N)
        {
            if(sum > max)
                max = sum;
            if(sum < min)
                min = sum;

            return;
        }

        if(plus > 0)
            foo(index + 1, sum + A[index], plus - 1, minus, mul, div);
        if(minus > 0)
            foo(index + 1, sum - A[index], plus, minus - 1, mul, div);
        if(mul > 0)
            foo(index + 1, sum * A[index], plus, minus, mul - 1, div);
        if(div > 0 && A[index] != 0)
            foo(index + 1, sum / A[index], plus, minus, mul, div - 1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++)
            cnt[i] = Integer.parseInt(st.nextToken());

        foo(1, A[0], cnt[0], cnt[1], cnt[2], cnt[3]);

        System.out.println(max);
        System.out.println(min);
    }
}
