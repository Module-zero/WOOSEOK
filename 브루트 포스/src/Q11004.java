/*
K번째 수

https://www.acmicpc.net/problem/11004
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 8:52
 */

public class Q11004
{
    static int[] ary = new int[5000001];
    static int[] tmp = new int[5000001];

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
        int j = mid+1;
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        sort(0, N-1);

        System.out.println(ary[K-1]);
    }
}
