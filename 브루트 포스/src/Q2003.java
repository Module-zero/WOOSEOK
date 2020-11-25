/*
수들의 합

https://www.acmicpc.net/problem/2003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 5:43
 */

public class Q2003
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[10001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int sId = 0;
        int eId = 0;

        int sum = ary[0];
        int ans = 0;
        while(eId < N)
        {
            if(sum == M)
            {
                ans++;

                sum += ary[++eId];
            }
            else if(sum < M)
                sum += ary[++eId];
            // sum > M
            else
                sum -= ary[sId++];
        }

        System.out.println(ans);
    }
}
