/*
토너먼트

https://www.acmicpc.net/problem/1057
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 5:15
 */

public class Q1057
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;

        while(N > 1)
        {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            cnt++;

            if(a == b)
                break;

            N = (N + 1) / 2;
        }

        System.out.println(cnt);
    }
}
