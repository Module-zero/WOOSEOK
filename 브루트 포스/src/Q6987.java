/*
월드컵

https://www.acmicpc.net/problem/6987
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오전 12:00
 */

public class Q6987
{
    static int[] win = new int[6];
    static int[] draw = new int[6];
    static int[] lose = new int[6];

    public static int foo(int a, int b)
    {
        if(a == 5)
        {
            for(int i=0; i<6; i++)
            {
                if(win[i] != 0 || draw[i] != 0 || lose[i] != 0)
                    return 0;
            }

            return 1;
        }

        int ret = 0;
        if(win[a] > 0 && lose[b] > 0)
        {
            win[a]--;
            lose[b]--;

            if(b == 5)
                ret = foo(a+1, a+2);
            else
                ret = foo(a, b+1);

            win[a]++;
            lose[b]++;
        }

        if(ret == 0)
        {
            if(draw[a] > 0 && draw[b] > 0)
            {
                draw[a]--;
                draw[b]--;

                if(b == 5)
                    ret = foo(a+1, a+2);
                else
                    ret = foo(a, b+1);

                draw[a]++;
                draw[b]++;
            }
        }

        if(ret == 0)
        {
            if(lose[a] > 0 && win[b] > 0)
            {
                lose[a]--;
                win[b]--;

                if(b == 5)
                    ret = foo(a+1, a+2);
                else
                    ret = foo(a, b+1);

                lose[a]++;
                win[b]++;
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        for(int k=0; k<4; k++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<6; i++)
            {
                win[i] = Integer.parseInt(st.nextToken());
                draw[i] = Integer.parseInt(st.nextToken());
                lose[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(foo(0, 1)).append(' ');
        }

        System.out.println(sb.toString());
    }
}
