/*
백대열

https://www.acmicpc.net/problem/14490
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 11:59
 */

public class Q14490
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tn = n;
        int tm = m;
        while(tm > 0)
        {
            int r = tn % tm;
            tn = tm;
            tm = r;
        }

        System.out.println(n/tn + ":" + m/tn);
    }
}
