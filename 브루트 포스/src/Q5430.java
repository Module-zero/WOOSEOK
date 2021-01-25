/*
AC

https://www.acmicpc.net/problem/5430
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 9:22
 */

public class Q5430
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    public static void foo() throws IOException
    {
        String p = br.readLine();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

        int[] ary = new int[100001];
        for(int i=0; i<n; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = n;
        int size = n;
        boolean dir = false;

        int len = p.length();
        for(int i=0; i<len; i++)
        {
            char ch = p.charAt(i);

            if(ch == 'R')
            {
                int tmp = start;
                start = end;
                end = tmp;
                dir = !dir;
            }
            else if(ch == 'D')
            {
                if(size == 0)
                {
                    sb.append("error\n");
                    return;
                }

                size--;
                // 뒤집음
                if(dir)
                    start--;
                // 뒤집지 않음
                else
                    start++;
            }
        }

        sb.append('[');

        // 뒤집음
        if(dir)
        {
            for(int i=start-1; i>end; i--)
                sb.append(ary[i]).append(',');

            if(size > 0)
                sb.append(ary[end]);

            sb.append("]\n");
        }
        else
        {
            for(int i=start; i<end-1; i++)
                sb.append(ary[i]).append(',');

            if(size > 0)
                sb.append(ary[end-1]);

            sb.append("]\n");
        }
    }

    public static void main(String[] args) throws IOException
    {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
            foo();

        System.out.print(sb.toString());
    }
}
