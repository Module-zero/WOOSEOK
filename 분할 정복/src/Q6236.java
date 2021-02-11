/*
용돈 관리

https://www.acmicpc.net/problem/6236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 8:40
 */

public class Q6236
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[100001];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            max = Integer.max(max, ary[i]);
        }

        int start = 0;
        int end = max * N;
        int ans = end;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            int cnt = 1;
            int sum = 0;
            for(int i=0; i<N; i++)
            {
                if(ary[i] > mid)
                {
                    cnt = 9999999;
                    break;
                }

                if(sum + ary[i] > mid)
                {
                    cnt++;
                    sum = ary[i];
                }
                else
                    sum += ary[i];
            }

            if(cnt > M)
                start = mid + 1;
            else
            {
                ans = Integer.min(ans, mid);
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
