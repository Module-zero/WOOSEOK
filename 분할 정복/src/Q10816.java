/*
숫자 카드 2

https://www.acmicpc.net/problem/10816
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오전 11:36
 */

public class Q10816
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[20000001];
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken()) + 10000000;
            cnt[num]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++)
        {
            int num = Integer.parseInt(st.nextToken()) + 10000000;
            sb.append(cnt[num]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
