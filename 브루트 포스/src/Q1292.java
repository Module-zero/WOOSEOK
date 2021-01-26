/*
쉽게 푸는 문제

https://www.acmicpc.net/problem/1292
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 4:47
 */

public class Q1292
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] ary = new int[2001];
        int id = 1;
        for(int i=1; i<50; i++)
        {
            for(int j=0; j<i; j++)
                ary[id++] = i;
        }

        int sum = 0;
        for(int i=A; i<=B; i++)
            sum += ary[i];

        System.out.println(sum);
    }
}
