/*
나무 자르기

https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 4:16
 */

public class Q2805
{
    static int N;
    static int M;
    static int[] ary = new int[1000001];

    public static long count(long start, long end)
    {
        long mid = (start + end) / 2;

        long cnt = 0;
        for(int i=0; i<N; i++)
        {
            // 자를 수 있는 크기일 경우에만 연산
            if(ary[i] > mid)
                cnt += (ary[i] - mid);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());
            if(max < ary[i])
                max = ary[i];
        }

        long ans = 0;
        long start = 1;
        long end = max;

        while(start <= end)
        {
            long mid = (start + end) / 2;

            // M보다 같거나 많이 잘랐을 경우 높이를 높여 더 적게 자른다.
            if(count(start, end) >= M)
            {
                if(ans <= mid)
                    ans = mid;

                start = mid + 1;
            }
            // M보다 적게 잘랐을 경우 높이를 낮춰 더 많이 자른다.
            else
                end = mid - 1;
        }

        System.out.println(ans);
    }
}
