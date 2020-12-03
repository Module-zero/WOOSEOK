/*
버블 소트

https://www.acmicpc.net/problem/1377
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-03
 * Time: 오전 12:19
 */

public class Q1377
{
    static int N;
    static int[] ary = new int[500001];
    static int[] tmp = new int[500001];

    public static void sort(int start, int end)
    {
        if(start == end)
            return;

        int mid = (start + end) / 2;
        sort(start, mid - 1);
        sort(mid, end);
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

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());
    }
}
