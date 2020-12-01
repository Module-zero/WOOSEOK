/*
수 묶기

https://www.acmicpc.net/problem/1744
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-26
 * Time: 오후 2:27
 */

public class Q1744
{
    static int N;
    static int[] pos = new int[10001];
    static int[] tmp = new int[10001];
    static int[] neg = new int[10001];

    public static void sort(int[] ary, int start, int end)
    {
        if(start == end)
            return;

        int mid = (start + end) / 2;

        sort(ary, start, mid);
        sort(ary, mid+1, end);
        merge(ary, start, end);
    }

    public static void merge(int[] ary, int start, int end)
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

        for(int a = start; a <= end; a++)
            ary[a] = tmp[a - start];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int posNum = 0;
        int negNum = 0;
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(num > 0)
                pos[posNum++] = num;
            else
                neg[negNum++] = num;
        }

        int ans = 0;
        int temp = 99999;

        if(posNum > 0)
        {
            sort(pos, 0, posNum - 1);

            for(int i=posNum-1; i>=0; i--)
            {
                if(temp == 99999)
                    temp = pos[i];
                else
                {
                    int sum = temp + pos[i];
                    int mul = temp * pos[i];

                    if(mul > sum)
                    {
                        ans += mul;
                        temp = 99999;
                    }
                    else
                    {
                        ans += temp;
                        temp = pos[i];
                    }
                }
            }

            if(temp != 99999)
            {
                ans += temp;
                temp = 99999;
            }
        }

        if(negNum > 0)
        {
            sort(neg, 0, negNum - 1);

            for(int i=0; i<negNum; i++)
            {
                if(temp == 99999)
                    temp = neg[i];
                else
                {
                    int sum = temp + neg[i];
                    int mul = temp * neg[i];

                    if(mul > sum)
                    {
                        ans += mul;
                        temp = 99999;
                    }
                    else
                    {
                        ans += temp;
                        temp = neg[i];
                    }
                }
            }

            if(temp != 99999)
                ans += temp;
        }

        System.out.println(ans);
    }
}
