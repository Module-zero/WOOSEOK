/*
N번째 큰 수

https://www.acmicpc.net/problem/2693
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 11:10
 */

public class Q2693
{
    static int[] A;
    static int[] tmp;

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
            if(A[i] >= A[j])
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

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = new int[10];
            for(int i=0; i<10; i++)
                A[i] = Integer.parseInt(st.nextToken());

            tmp = new int[10];

            sort(0, 9);

            sb.append(A[2]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
