/*
공유기 설치

https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 4:59
 */

public class Q2110
{
    static int N;
    static int C;
    static int[] x = new int[200001];
    static int[] tmp = new int[200001];
    static int max = Integer.MIN_VALUE;

    public static void foo(int start, int end)
    {
        if(start > end)
            return;

        int mid = (start + end) / 2;
        int cnt = 1;
        int j = 0;
        for(int i=1; i<N; i++)
        {
            int dist = x[i] - x[j];

            // 두 집 사이의 거리가 정해진 거리보다 같거나 크면 설치할 수 있음
            if(dist >= mid)
            {
                cnt++;
                // 설치한 위치로 갱신한다.
                j = i;
            }
        }

        // 정해진 공유기보다 많이 설치할 수 있다면 거리를 늘린다.
        if(cnt >= C)
        {
            if(mid > max)
                max = mid;

            foo(mid+1, end);
        }
        // 정해진 공유기보다 적게 설치해야 한다면 거리를 좁힌다.
        else
            foo(start, mid-1);
    }

    public static void sort(int start, int end)
    {
        if(start >= end)
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
            if(x[i] <= x[j])
                tmp[k++] = x[i++];
            else
                tmp[k++] = x[j++];
        }

        while(i <= mid)
            tmp[k++] = x[i++];
        while(j <= end)
            tmp[k++] = x[j++];

        for(int a=start; a<=end; a++)
            x[a] = tmp[a-start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            x[i] = Integer.parseInt(br.readLine());

        sort(0, N-1);
        foo(0, x[N-1] - x[0]);

        System.out.println(max);
    }
}
