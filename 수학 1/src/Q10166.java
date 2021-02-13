/*
관중석

https://www.acmicpc.net/problem/10166
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 9:11
 */

public class Q10166
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[2001][2001];
        int ans = 0;
        for(int i=d1; i<=d2; i++)
        {
            for(int j=1; j<=i; j++)
            {
                int a = i;
                int b = j;
                while(b > 0)
                {
                    int r = a % b;
                    a = b;
                    b = r;
                }

                // 이미 들렀던 기약분수면 continue;
                if(check[i/a][j/a])
                    continue;

                ans++;
                check[i/a][j/a] = true;
            }
        }

        System.out.println(ans);
    }
}
