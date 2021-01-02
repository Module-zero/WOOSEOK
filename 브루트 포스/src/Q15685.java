/*
드래곤 커브

https://www.acmicpc.net/problem/15685
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-02
 * Time: 오전 12:06
 */

public class Q15685
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};

        int[][] dragon = new int[4][1025];
        for(int i=0; i<4; i++)
        {
            // 0세대
            dragon[i][0] = i;
            dragon[i][1] = (i + 1) % 4;

            // 2~10세대
            for(int j=2; j<=10; j++)
            {
                int start = 1 << (j-1);
                int end = 1 << j;
                int mid = (start + end) / 2;

                for(int id=start; id<mid; id++)
                    dragon[i][id] = (dragon[i][id-start] + 2) % 4;

                for(int id=mid; id<end; id++)
                    dragon[i][id] = dragon[i][id-start];
            }
        }

        boolean[][] check = new boolean[101][101];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int end = 1 << g;
            check[y][x] = true;
            int[] dy = {0, -1, 0, 1};
            int[] dx = {1, 0, -1, 0};

            for(int id=0; id<end; id++)
            {
                int num = dragon[d][id];

                y += dy[num];
                if(y < 0 || y > 100)
                    continue;

                x += dx[num];
                if(x < 0 || x > 100)
                    continue;

                check[y][x] = true;
            }
        }

        int ans = 0;
        for(int i=0; i<100; i++)
        {
            for(int j=0; j<100; j++)
            {
                if(check[i][j] && check[i][j+1] && check[i+1][j] && check[i+1][j+1])
                    ans++;
            }
        }

        System.out.println(ans);
    }
}
