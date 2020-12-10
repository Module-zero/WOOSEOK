/*
광고

https://www.acmicpc.net/problem/1305
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-10
 * Time: 오후 2:53
 */

public class Q1305
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] pi = new int[1000001];
        int j = 0;
        for(int i=1; i<L; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j))
                j = pi[j-1];

            if(str.charAt(i) == str.charAt(j))
                pi[i] = ++j;
        }
    }
}
