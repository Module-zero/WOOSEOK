/*
반올림

https://www.acmicpc.net/problem/4539
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-26
 * Time: 오후 5:59
 */

public class Q4539
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(n-- > 0)
        {
            int x = Integer.parseInt(br.readLine());

            int num = 10;
            while(x >= num)
            {
                int dx = x % num;
                x -= dx;

                // 5~9
                if(dx >= num/2)
                    x += num;

                num *= 10;
            }

            sb.append(x).append('\n');
        }

        System.out.print(sb.toString());
    }
}
