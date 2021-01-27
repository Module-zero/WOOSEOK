/*
최대공약수

https://www.acmicpc.net/problem/1850
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 9:41
 */

public class Q1850
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long tA = a;
        long tB = b;
        while(tB > 0)
        {
            long r = tA % tB;
            tA = tB;
            tB = r;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<tA; i++)
            sb.append(1);

        System.out.println(sb.toString());
    }
}
