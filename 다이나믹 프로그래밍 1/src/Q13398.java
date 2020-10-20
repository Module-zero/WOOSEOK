/*
연속합 2

https://www.acmicpc.net/problem/13398
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오후 1:38
 */

public class Q13398
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        // 수를 뺀 왼쪽 부분의 연속합
        int[] dpL = new int[n+2];
        // 수를 뺀 왼쪽 부분의 연속합
        int[] dpR = new int[n+2];

        // 1부터 i까지의 최대 연속합
        for (int i=1; i<=n; i++)
        {
            dpL[i] = ary[i];

            int sum = dpL[i] + dpL[i-1];
            if (dpL[i] < sum)
                dpL[i] = sum;

            if(max < dpL[i])
                max = dpL[i];
        }

        // i부터 n까지의 연속합
        for (int i=n; i>=1; i--)
        {
            dpR[i] = ary[i];

            int sum = dpR[i] + dpR[i+1];
            if (dpR[i] < sum)
                dpR[i] = sum;
        }

        for(int i=1; i<=n; i++)
        {
            if(max < dpL[i])
                max = dpL[i];

            // n이 1일 경우 1개를 뺄 수 없다.
            if(n != 1)
            {
                int sum = dpL[i - 1] + dpR[i + 1];
                if (max < sum)
                    max = sum;
            }
        }

        System.out.println(max);
    }
}
