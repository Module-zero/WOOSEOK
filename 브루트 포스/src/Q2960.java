/*
에라토스테네스의 체

https://www.acmicpc.net/problem/2960
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 11:17
 */

public class Q2960
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[1001];
        int cnt = 0;
        for(int i=2; i<=N; i++)
        {
            if(check[i])
                continue;

            for(int j=i; j<=N; j+=i)
            {
                if(check[j])
                    continue;

                check[j] = true;
                cnt++;
                if(cnt == K)
                {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
