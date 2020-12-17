/*
예산

https://www.acmicpc.net/problem/2512
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 3:49
 */

public class Q2512
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[10001];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, ary[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int ans = 0;
        int left = 0;
        int right = max;

        while(left <= right)
        {
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i=0; i<N; i++)
            {
                if(ary[i] <= mid)
                    sum += ary[i];
                else
                    sum += mid;
            }

            if(sum <= M)
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        System.out.println(ans);
    }
}
