/*
캠핑

https://www.acmicpc.net/problem/4796
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 10:55
 */

public class Q4796
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int tc = 1;
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L == 0 || P == 0 || V == 0)
                break;

            int day = V / P * L + Integer.min(L, V % P);

            sb.append("Case ").append(tc).append(": ").append(day).append('\n');
            tc++;
        }

        System.out.print(sb.toString());
    }
}
