/*
소수의 연속합

https://www.acmicpc.net/problem/1644
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 9:34
 */

public class Q1644
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] notPrime = new boolean[4100001];
        int[] ary = new int[300000];
        int pNum = 0;
        for(int i=2; i<=4100000; i++)
        {
            if(notPrime[i])
                continue;

            ary[pNum++] = i;

            for(int j=2*i; j<=4100000; j+=i)
                notPrime[j] = true;
        }

        int N = Integer.parseInt(br.readLine());
        int lId = 0;
        int rId = 0;
        int sum = ary[0];
        int ans = 0;
        while(ary[rId] <= N)
        {
            if(sum == N)
            {
                ans++;
                sum += ary[++rId];
            }
            else if(sum < N)
                sum += ary[++rId];
            else
                sum -= ary[lId++];
        }

        System.out.println(ans);
    }
}
