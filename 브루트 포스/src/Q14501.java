/*
퇴사

https://www.acmicpc.net/problem/14501
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 9:42
 */

public class Q14501
{
    static int N;
    static int[] T;
    static int[] P;
    static int max = Integer.MIN_VALUE;

    public static void foo(int time, int pay)
    {
        if(time > N+1)
            return;

        if(time == N+1)
        {
            if(max < pay)
                max = pay;

            return;
        }

        // 그 날 상담
        foo(time+T[time], pay+P[time]);
        // 그 날 상담 안함
        foo(time+1, pay);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = new int[N+1];
        P = new int[N+1];

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        foo(1, 0);
        System.out.println(max);
    }
}
