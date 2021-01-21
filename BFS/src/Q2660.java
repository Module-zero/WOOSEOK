/*
회장뽑기

https://www.acmicpc.net/problem/2660
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-05
 * Time: 오후 12:03
 */

public class Q2660
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            if(f1 == -1 && f2 == -1)
                break;
        }
    }
}
