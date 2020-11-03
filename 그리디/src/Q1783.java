/*
병든 나이트

https://www.acmicpc.net/problem/1783
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-03
 * Time: 오후 4:37
 */

public class Q1783
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N == 1)
        {
            System.out.println("1");
        }
        else if(N == 2)
        {
            int cnt = (M+1)/2;
            System.out.println(Integer.min(4, cnt));
        }
        else
        {
            if(M >= 7)
                System.out.println(M-2);
            else
                System.out.println(Integer.min(4, M));
        }
    }
}
