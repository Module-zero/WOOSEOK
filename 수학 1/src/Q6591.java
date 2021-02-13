/*
이항 쇼다운

https://www.acmicpc.net/problem/6591
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-12
 * Time: 오전 12:17
 */

public class Q6591
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0)
                break;

            b = Integer.min(b, a - b);

            long ans = 1;
            int div = 1;
            while(b-- > 0)
            {
                ans *= a--;
                ans /= div++;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
