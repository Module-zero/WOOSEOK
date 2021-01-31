/*
개미

https://www.acmicpc.net/problem/10158
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 8:59
 */

public class Q10158
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        p += t;
        q += t;

        p %= 2*w;
        q %= 2*h;

        if(p > w)
            p = 2*w - p;
        if(q > h)
            q = 2*h - q;

        System.out.println(p + " " + q);
    }
}
