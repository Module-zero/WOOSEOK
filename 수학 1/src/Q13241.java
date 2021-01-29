/*
최소공배수

https://www.acmicpc.net/problem/13241
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오전 11:42
 */

public class Q13241
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long tA = A;
        long tB = B;
        while(tB > 0)
        {
            long r = tA % tB;
            tA = tB;
            tB = r;
        }

        long ans = (A * B) / tA;
        System.out.println(ans);
    }
}
