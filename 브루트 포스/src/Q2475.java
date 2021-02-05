/*
검증수

https://www.acmicpc.net/problem/2475
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 5:27
 */

public class Q2475
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[5];
        for(int i=0; i<5; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i=0; i<5; i++)
            sum += ary[i] * ary[i];

        System.out.println(sum % 10);
    }
}
