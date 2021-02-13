/*
파스칼의 삼각형

https://www.acmicpc.net/problem/16395
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-13
 * Time: 오후 8:29
 */

public class Q16395
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken()) - 1;

        long ans = 1;
        k = Integer.min(k, n-k);
        int div = 1;

        for(int i=0; i<k; i++)
        {
            ans *= n--;
            ans /= div++;
        }

        System.out.println(ans);
    }
}
