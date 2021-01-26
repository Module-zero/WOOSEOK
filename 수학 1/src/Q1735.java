/*
분수 합

https://www.acmicpc.net/problem/1735
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 3:53
 */

public class Q1735
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int ja1 = Integer.parseInt(st.nextToken());
        int mo1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ja2 = Integer.parseInt(st.nextToken());
        int mo2 = Integer.parseInt(st.nextToken());

        int ja = ja1 * mo2 + ja2 * mo1;
        int mo = mo1 * mo2;

        int tA = ja;
        int tB = mo;

        while(tB > 0)
        {
            int r = tA % tB;
            tA = tB;
            tB = r;
        }

        StringBuffer sb = new StringBuffer().append(ja/tA).append(' ').append(mo/tA);
        System.out.println(sb.toString());
    }
}
