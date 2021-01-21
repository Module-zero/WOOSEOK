/*
터렛

https://www.acmicpc.net/problem/1002
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-21
 * Time: 오후 11:06
 */

public class Q1002
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1, y1, r1, x2, y2, r2;

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            if(x1 == x2 && y1 == y2 && r1 == r2)
            {
                sb.append(-1).append('\n');
                continue;
            }

            int diff = Math.abs(r1 - r2);
            diff *= diff;
            int sum = r1 + r2;
            sum *= sum;

            int ds = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));

            if(ds == 0 || sum < ds || ds < diff)
                sb.append(0).append('\n');
            else if(ds == sum || ds == diff)
                sb.append(1).append('\n');
            else
                sb.append(2).append('\n');
        }

        System.out.print(sb.toString());
    }
}
