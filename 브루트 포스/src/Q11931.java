/*
수 정렬하기 4

https://www.acmicpc.net/problem/11931
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 12:30
 */

public class Q11931
{
    static int[] ary = new int[1000001];
    static int[] tmp = new int[1000001];

    public static void sort(int left, int right)
    {
        if(left >= right)
            return;

        int mid = (left + right) / 2;

        sort(left, mid);
        sort(mid+1, right);
        merge(left, right);
    }

    public static void merge(int left, int right)
    {
        int mid = (left + right) / 2;

        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right)
        {
            if(ary[i] > ary[j])
                tmp[k++] = ary[i++];
            else
                tmp[k++] = ary[j++];
        }

        while(i <= mid)
            tmp[k++] = ary[i++];

        while(j <= right)
            tmp[k++] = ary[j++];

        for(int a=left; a<=right; a++)
            ary[a] = tmp[a-left];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
            sb.append(ary[i]).append('\n');

        System.out.print(sb.toString());
    }
}
