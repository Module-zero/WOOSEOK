/*
동전 게임

https://www.acmicpc.net/problem/10837
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오후 8:41
 */

public class Q10837
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<C; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rem = K - Math.max(a, b);
            int diff = Math.abs(a - b);

            if(a == b)
                sb.append("1\n");
            else if(a > b)
            {
                if(diff - rem <= 2)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else
            {
                if(diff - rem <= 1)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
        }

        System.out.print(sb.toString());
    }
}
