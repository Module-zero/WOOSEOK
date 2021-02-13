/*
색종이 - 2

https://www.acmicpc.net/problem/2567
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-13
 * Time: 오후 11:46
 */

public class Q2567
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[102][102];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int x=l+1; x<=l+10; x++)
            {
                for(int y=d+1; y<=d+10; y++)
                    check[y][x] = true;
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        int ans = 0;
        for(int i=1; i<101; i++)
        {
            for(int j=1; j<101; j++)
            {
                if(!check[i][j])
                    continue;

                int cnt = 0;
                for(int k=0; k<4; k++)
                {
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    if(!check[newR][newC])
                        cnt++;
                }

                ans += cnt;
            }
        }

        System.out.println(ans);
    }
}
