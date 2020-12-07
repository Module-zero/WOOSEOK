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
    static Bubble[] A = new Bubble[500001];
    static Bubble[] tmp = new Bubble[500001];

    static class Bubble
    {
        int num;
        int order;

        public Bubble(int num, int order)
        {
            this.num = num;
            this.order = order;
        }
    }

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
            if(A[i].num <= A[j].num)
                tmp[k++] = A[i++];
            else
                tmp[k++] = A[j++];
        }

        while(i <= mid)
            tmp[k++] = A[i++];
        while(j <= end)
            tmp[k++] = A[j++];

        for(int a=start; a<=end; a++)
            A[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            A[i] = new Bubble(num, i);
        }

        sort(0, N-1);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            int ans = A[i].order - i;

            if(ans > max)
                max = ans;
        }

        System.out.println(max+1);
    }
}
