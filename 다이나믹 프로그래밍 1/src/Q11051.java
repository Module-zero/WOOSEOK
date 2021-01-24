/*
이항계수 2

https://www.acmicpc.net/problem/11051
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-23
 * Time: 오후 11:54
 */

public class Q11051
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = Integer.min(K, N-K);

        int[][] C = new int[1001][1001];
        C[0][0] = 1;
        for(int i=1; i<=N; i++)
        {
            C[i][0] = 1;
            for(int j=1; j<=min; j++)
                C[i][j] = ((C[i-1][j-1] % 10007) + (C[i-1][j] % 10007)) % 10007;
        }

        System.out.println(C[N][min]);
    }
}
