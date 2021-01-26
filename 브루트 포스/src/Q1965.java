/*
상자넣기

https://www.acmicpc.net/problem/1965
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 3:43
 */

public class Q1965
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxCnt = Integer.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=1; i<=n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[1001];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                if(ary[i-j] < ary[i])
                    cnt[i] = Integer.max(cnt[i-j] + 1, cnt[i]);
            }

            if(cnt[i] == 0)
                cnt[i] = 1;

            maxCnt = Integer.max(maxCnt, cnt[i]);
        }

        System.out.println(maxCnt);
    }
}
