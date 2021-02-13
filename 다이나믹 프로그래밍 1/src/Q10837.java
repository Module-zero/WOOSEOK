/*
동전 게임

https://www.acmicpc.net/problem/10837
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-12
 * Time: 오전 12:36
 */

public class Q10837
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[1001][1001];
        for(int a=0; a<K; a++)
        {
            for(int b=0; b<K; b++)
            {
                if(a > b)
                {
                    int rem = K - a;

                    
                }
                else if(a == b)
                    check[a][b] = true;
                else
                {
                    int rem = K - b;

                }
            }
        }

        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


        }
    }
}
