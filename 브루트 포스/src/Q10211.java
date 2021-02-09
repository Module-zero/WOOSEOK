/*
Maximum Subarray

https://www.acmicpc.net/problem/10211
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-09
 * Time: 오후 4:58
 */

public class Q10211
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int[] ary = new int[1001];
            int[] ps = new int[1001];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<=N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            for(int i=1; i<=N; i++)
            {
                ps[i] = Integer.max(ps[i-1] + ary[i], ary[i]);
                max = Integer.max(max, ps[i]);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
