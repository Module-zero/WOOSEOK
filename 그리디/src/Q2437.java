/*
저울

https://www.acmicpc.net/problem/2437
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 7:42
 */

public class Q2437
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary, 0, N);
        int sum = 0;
        for(int i=0; i<N; i++)
        {
            if(sum + 1 < ary[i])
            {
                break;
            }

            sum += ary[i];
        }

        System.out.println(sum + 1);
    }
}
