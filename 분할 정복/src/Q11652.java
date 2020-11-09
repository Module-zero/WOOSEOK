/*
카드

https://www.acmicpc.net/problem/11652
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오전 12:49
 */

public class Q11652
{
    static long[] ary = new long[100001];
    static long[] tmp = new long[100001];

    public static void sort(int start, int end)
    {
        if(start == end)
            return;

        int mid = (start + end) / 2;

        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start + end) / 2;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end)
        {
            if(ary[i] < ary[j])
                tmp[k++] = ary[i++];
            else
                tmp[k++] = ary[j++];
        }

        while(i <= mid)
            tmp[k++] = ary[i++];
        while(j <= end)
            tmp[k++] = ary[j++];

        for(int a=start; a<=end; a++)
            ary[a] = tmp[a - start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Long.parseLong(br.readLine());

        sort(0, N-1);

        int cnt = 1;
        int maxCnt = 1;
        long maxValue = ary[0];
        int i=1;

        for(; i<N; i++)
        {
            if(ary[i] == ary[i-1])
                cnt++;
            else
            {
                if(maxCnt < cnt)
                {
                    maxCnt = cnt;
                    maxValue = ary[i-1];
                }

                cnt = 1;
            }
        }

        if(maxCnt < cnt)
            maxValue = ary[i-1];

        System.out.println(maxValue);
    }
}
