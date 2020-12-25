/*
텀 프로젝트

https://www.acmicpc.net/problem/9466
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-25
 * Time: 오후 11:09
 */

public class Q9466
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            int[] ary = new int[100001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++)
                ary[i] = Integer.parseInt(st.nextToken());


        }
    }
}
