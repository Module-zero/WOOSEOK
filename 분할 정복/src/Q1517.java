/*
버블 소트

https://www.acmicpc.net/problem/1517
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-09
 * Time: 오후 5:57
 */

public class Q1517
{
    static int N;
    static long cnt = 0;
    static int[] ary = new int[500001];
    static int[] ans = new int[500001];

    public static void sort(int start, int end)
    {
        if(start == end)
            return;

        int mid = (start+end)/2;
        sort(start, mid);
        sort(mid+1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start+end)/2;

        int l = start;
        int r = mid+1;
        int k = 0;

        while(l <= mid && r <= end)
        {
            if(ary[l] <= ary[r])
                ans[k++] = ary[l++];
            else
            {
                ans[k++] = ary[r++];
                cnt += (mid - l + 1);
            }
        }

        while(l <= mid)
            ans[k++] = ary[l++];
        while(r <= end)
            ans[k++] = ary[r++];

        for(int i=start; i<=end; i++)
            ary[i] = ans[i-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        sort(0, N-1);
        System.out.println(cnt);
    }
}
