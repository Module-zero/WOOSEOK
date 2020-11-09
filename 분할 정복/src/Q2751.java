/*
수 정렬하기 2

https://www.acmicpc.net/problem/2751
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-09
 * Time: 오후 6:28
 */

public class Q2751
{
    static int N;
    static int[] ary = new int[1000001];
    static int[] tmp = new int[1000001];

    public static void sort(int start, int end)
    {
        if(start == end)
            return;

        int mid = (start + end)/2;

        sort(start, mid);
        sort(mid+1, end);
        merge(start, end);
    }

    public static void merge(int start, int end)
    {
        int mid = (start+end)/2;

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
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++)
            sb.append(ary[i]).append("\n");

        System.out.print(sb.toString());
    }
}
