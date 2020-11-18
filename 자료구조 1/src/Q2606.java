/*
바이러스

https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 5:05
 */

public class Q2606
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[101][101];
        boolean[] ans = new boolean[101];

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
            check[b][a] = true;
        }

        ans[1] = true;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(ans[i] && check[i][j])
                    ans[j] = true;
            }
        }

        int cnt = 0;
        for(int i=2; i<=n; i++)
        {
            if(ans[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
