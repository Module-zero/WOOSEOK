/*
링

https://www.acmicpc.net/problem/3036
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 5:06
 */

public class Q3036
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<N; i++)
        {
            int tA = ary[0];
            int tB = ary[i];

            while(tB > 0)
            {
                int r = tA % tB;
                tA = tB;
                tB = r;
            }

            sb.append(ary[0]/tA).append('/').append(ary[i]/tA).append('\n');
        }

        System.out.print(sb.toString());
    }
}
