/*
가로수

https://www.acmicpc.net/problem/2485
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-08
 * Time: 오후 8:39
 */

public class Q2485
{
    static int[] ary = new int[100001];
    static int[] tmp = new int[100001];

    public static void sort(int start, int end)
    {
        if(start >= end)
            return;

        int mid = (start + end) / 2;
        sort(start, mid);
        sort(mid+1, end);
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
            ary[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);

        int min = ary[1] - ary[0];
        for(int i=2; i<N; i++)
        {
            int diff = ary[i] - ary[i - 1];

            int tA = min;
            int tB = diff;
            while(tB > 0)
            {
                int r = tA % tB;
                tA = tB;
                tB = r;
            }

            min = Integer.min(tA, min);
        }

        int cnt = 0;
        for(int i=1; i<N; i++)
        {
            int diff = ary[i] - ary[i-1];
            cnt += (diff / min) - 1;
        }

        System.out.println(cnt);
    }
}
