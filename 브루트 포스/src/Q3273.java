/*
두 수의 합

https://www.acmicpc.net/problem/3273
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오후 7:33
 */

public class Q3273
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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        sort(0, n-1);

        int si = 0;
        int ei = n-1;
        int cnt = 0;
        while(si < ei)
        {
            int sum = ary[si] + ary[ei];

            if(sum == x)
            {
                cnt++;
                si++;
            }
            else if(sum > x)
                ei--;
            else
                si++;
        }

        System.out.println(cnt);
    }
}
