/*
구간 합 구하기 4

https://www.acmicpc.net/problem/11659
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 6:32
 */

public class Q11659
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] pSum = new int[100001];

        for(int i=1; i<=N; i++)
            pSum[i] = pSum[i-1] + ary[i];

        StringBuffer sb = new StringBuffer();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = pSum[b] - pSum[a-1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}
