/*
Z

https://www.acmicpc.net/problem/1074
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오후 5:39
 */

public class Q1074
{
    public static int cnt = 0;
    public static int N;
    public static int r;
    public static int c;

    public static void foo(int y, int x, int n)
    {
        // 더 이상 쪼갤 수 없는 크기
        if(n == 1)
            return;

        int mid = n / 2;
        int size = mid * mid;

        int midY = mid + y;
        int midX = mid + x;

        // 1사분면
        if(r < midY && c < midX)
            foo(y, x, n/2);
        // 2사분면
        else if(r < midY && c >= midX)
        {
            cnt += size;
            foo(y, midX, n/2);
        }
        // 3사분면
        else if(r >= midY && c < midX)
        {
            cnt += 2 * size;
            foo(midY, x, n/2);
        }
        // 4사분면
        else
        {
            cnt += 3 * size;
            foo(midY, midX, n/2);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = 2 << N;

        foo(0, 0, n);

        System.out.println(cnt);
    }
}
