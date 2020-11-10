/*
수 이어 쓰기 2

https://www.acmicpc.net/problem/1790
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 2:17
 */

public class Q1790
{
    static int N;
    static int k;

    public static int count(int n)
    {
        int cnt = 0;
        int dn = 10;
        int ddn = 1;
        int rem = 1;

        while(n >= dn)
        {
            // ddn ~ dn-1까지는 rem자릿수
            cnt += (dn - 1 - ddn + 1) * rem;

            ddn = dn;
            dn *= 10;

            rem++;
        }

        cnt += (n - ddn + 1) * rem;

        return cnt;
    }

    public static void foo(int start, int end)
    {
        if(start == end)
        {
            // 문자열로 만든다.
            String str = start + "";
            // 이전 값까지의 자릿수를 센다.
            int cnt = count(start-1);
            System.out.println(str.charAt(k - cnt - 1));

            return;
        }

        int mid = (start + end) / 2;

        // 1 ~ mid까지의 개수가 k보다 같거나 크면 범위를 낮춰야 함(k보다 많은 수가 포함되어 있다는 의미)
        if(count(mid) >= k)
            foo(start, mid);
        else
            foo(mid+1, end);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(count(N) < k)
        {
            System.out.println(-1);
            return;
        }

        foo(1, N);
    }
}
