/*
수열의 합

https://www.acmicpc.net/problem/1024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 9:57
 */

public class Q1024
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        int i=L;
        for(; i<=100; i++)
        {
            // 짝수
            if(i % 2 == 0)
            {
                // ex)
                if(N % i == i/2)
                {
                    int rem = N / i;
                    int si = rem - i/2 + 1;
                    if(si < 0)
                    {
                        sb.append(-1);
                        break;
                    }

                    int ei = rem + i/2;

                    while(si <= ei)
                    {
                        sb.append(si).append(' ');
                        si++;
                    }

                    break;
                }
            }
            // 홀수
            else
            {
                // ex) 18 % 3 = 5 6 7
                if(N % i == 0)
                {
                    int rem = N / i;
                    int si = rem - i/2;
                    if(si < 0)
                    {
                        sb.append(-1);
                        break;
                    }

                    int ei = rem + i/2;
                    while(si <= ei)
                    {
                        sb.append(si).append(' ');
                        si++;
                    }

                    break;
                }
            }
        }
        if(i > 100)
            sb.append(-1);

        System.out.println(sb.toString());
    }
}
