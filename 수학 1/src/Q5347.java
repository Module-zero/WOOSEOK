/*
LCM

https://www.acmicpc.net/problem/5347
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 11:44
 */

public class Q5347
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(n-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int tA = a;
            int tB = b;
            while(tB > 0)
            {
                int r = tA % tB;
                tA = tB;
                tB = r;
            }

            sb.append((long)a * b / tA).append('\n');
        }

        System.out.print(sb.toString());
    }
}
