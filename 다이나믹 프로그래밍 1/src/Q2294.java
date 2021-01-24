/*
동전 2

https://www.acmicpc.net/problem/2294
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 5:46
 */

public class Q2294
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ary = new int[100];
        for(int i=0; i<n; i++)
            ary[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ary, 0, n);
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--)
        {
            int rem = k;
            int cnt = 0;

            for(int j=i; j>=0; j--)
            {
                cnt += rem / ary[j];
                rem %= ary[j];

                if(rem == 0)
                {
                    min = Integer.min(min, cnt);
                    break;
                }
            }
        }

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }
}
