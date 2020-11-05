/*
숫자 카드

https://www.acmicpc.net/problem/10815
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오전 1:20
 */

public class Q10815
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] plus = new boolean[10000001];
        boolean[] minus = new boolean[10000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());

            if(num >= 0)
                plus[num] = true;
            else
            {
                num = -num;
                minus[num] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
        {
            int num = Integer.parseInt(st.nextToken());

            if(num >= 0)
            {
                if(plus[num])
                    sb.append(1).append(" ");
                else
                    sb.append(0).append(" ");
            }
            else
            {
                num = -num;

                if(minus[num])
                    sb.append(1).append(" ");
                else
                    sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
