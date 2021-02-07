/*
인형들

https://www.acmicpc.net/problem/15954
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 5:08
 */

public class Q15954
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[501];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] ps = new int[501];
        for(int i=1; i<=N; i++)
            ps[i] = ps[i-1] + ary[i];

        double ans = Double.MAX_VALUE;
        for(int i=K; i<=N; i++)
        {
            for(int start=i; start<=N; start++)
            {
                double tm = (ps[start] - ps[start-i]) / (double)i;

                double sum = 0;
                for(int j=start; j>start-i; j--)
                {
                    double tmp = ary[j] - tm;
                    sum += tmp * tmp;
                }

                ans = Double.min(ans, Math.sqrt(sum / i));
            }
        }

        System.out.println(ans);
    }
}
