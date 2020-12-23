/*
미세먼지 안녕!

https://www.acmicpc.net/problem/17144
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-23
 * Time: 오후 6:13
 */

public class Q17144
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int cleaner = -1;
        int[][] map = new int[51][51];
        for(int i=0; i<R; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<C; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && cleaner == -1)
                    cleaner = i;
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while(T-- > 0)
        {
            // 미세먼지 변동량 저장
            int[][] d = new int[101][101];
            for(int i=0; i<R; i++)
            {
                for(int j=0; j<C; j++)
                {
                    // 미세먼지가 칸에 존재할 경우 확산
                    if(map[i][j] > 0)
                    {
                        for(int k=0; k<4; k++)
                        {
                            int newR = i + dr[k];
                            if(newR < 0 || newR >= R)
                                continue;

                            int newC = j + dc[k];
                            if(newC < 0 || newC >= C)
                                continue;

                            // 공기청정기가 있을 경우 확산하지 않는다.
                            if(map[newR][newC] == -1)
                                continue;

                            // 미세먼지 확산량 기록
                            d[newR][newC] += map[i][j]/5;
                            d[i][j] -= map[i][j]/5;
                        }
                    }
                }
            }

            // 변동된 미세먼지량 적용
            for(int i=0; i<R; i++)
            {
                for(int j=0; j<C; j++)
                {
                    if(d[i][j] != 0)
                        map[i][j] += d[i][j];
                }
            }

            // 공기청정기 시계방향 적용
            for(int newR = cleaner-2; newR >= 0; newR--)
                map[newR+1][0] = map[newR][0];
            for(int newC = 1; newC < C; newC++)
                map[0][newC-1] = map[0][newC];
            for(int newR = 1; newR <= cleaner; newR++)
                map[newR-1][C-1] = map[newR][C-1];
            for(int newC = C-2; newC > 0; newC--)
                map[cleaner][newC+1] = map[cleaner][newC];
            map[cleaner][1] = 0;

            // 공기청정기 반시계방향 적용
            for(int newR = cleaner+3; newR < R; newR++)
                map[newR-1][0] = map[newR][0];
            for(int newC = 1; newC < C; newC++)
                map[R-1][newC-1] = map[R-1][newC];
            for(int newR = R-2; newR >= cleaner+1; newR--)
                map[newR+1][C-1] = map[newR][C-1];
            for(int newC = C-2; newC > 0; newC--)
                map[cleaner+1][newC+1] = map[cleaner+1][newC];

            map[cleaner+1][1] = 0;
        }

        int ans = 0;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(map[i][j] > 0)
                    ans += map[i][j];
            }
        }

        System.out.println(ans);
    }
}
