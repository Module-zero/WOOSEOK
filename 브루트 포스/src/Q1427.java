/*
소트인사이드

https://www.acmicpc.net/problem/1427
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-21
 * Time: 오후 5:29
 */

public class Q1427
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ary = new Integer[10];
        int i = 0;
        while(N > 0)
        {
            ary[i++] = N % 10;
            N /= 10;
        }

        Arrays.sort(ary, 0, i, Collections.reverseOrder());
        StringBuffer sb = new StringBuffer();
        for(int k=0; k<i; k++)
            sb.append(ary[k]);

        System.out.println(sb.toString());
    }
}
