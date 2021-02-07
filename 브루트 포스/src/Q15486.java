/*
퇴사 2

https://www.acmicpc.net/problem/15486
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 10:01
 */

public class Q15486
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[1500001];
        int[] P = new int[1500001];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] ps = new int[1500001];
        for(int i=1; i<=N; i++)
        {
            ps[i] = Integer.max(ps[i-1], ps[i]);

            if(i + T[i] - 1 > N)
                continue;

            ps[i + T[i] - 1] = Integer.max(ps[i-1] + P[i], ps[i + T[i] - 1]);
        }

        System.out.println(ps[N]);
    }
}
