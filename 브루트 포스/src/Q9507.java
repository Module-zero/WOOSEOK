/*
Generations of Tribbles

https://www.acmicpc.net/problem/9507
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 7:28
 */

public class Q9507
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] n = new long[68];
        n[0] = 1;
        n[1] = 1;
        n[2] = 2;
        n[3] = 4;

        for(int i=4; i<68; i++)
            n[i] = n[i-1] + n[i-2] + n[i-3] + n[i-4];

        StringBuffer sb = new StringBuffer();
        while(t-- > 0)
        {
            int num = Integer.parseInt(br.readLine());
            sb.append(n[num]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
