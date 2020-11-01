/*
ATM

https://www.acmicpc.net/problem/11399
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 5:35
 */

public class Q11399
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[1000];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int wait = 0;

        Arrays.sort(ary, 0, N);

        for(int i=0; i<N; i++)
        {
            wait += ary[i];
            sum += wait;
        }

        System.out.println(sum);
    }
}
