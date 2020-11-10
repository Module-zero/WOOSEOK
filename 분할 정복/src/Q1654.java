/*
랜선 자르기

https://www.acmicpc.net/problem/1654
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 3:03
 */

public class Q1654
{
    static int K;
    static int N;
    static int[] ary = new int[10001];

    public static long count(long start, long end)
    {
        long mid = (start + end) / 2;
        long cnt = 0;

        for(int i=0; i<K; i++)
            cnt += (ary[i] / mid);

        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        long max = Long.MIN_VALUE;

        for(int i=0; i<K; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            if(ary[i] > max)
                max = ary[i];
        }

        long ans = 0;
        long start = 1;
        long end = max;

        while(start <= end)
        {
            long mid = (start + end) / 2;

            // N개보다 많은 랜선이 나오면 자를 길이를 늘린다.
            if(count(start, end) >= N)
            {
                if(ans < mid)
                    ans = mid;

                start = mid + 1;
            }
            // N개보다 적은 랜선이 나오면 자를 길이를 줄인다.
            else
                end = mid - 1;
        }

        System.out.println(ans);
    }
}
