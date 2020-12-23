/*
지구 온난화

https://www.acmicpc.net/problem/5212
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-21
 * Time: 오후 5:56
 */

public class Q5212
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[11][11];
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                map[i][j] = str.charAt(j);
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int sR = R;
        int sC = C;
        int eR = 0;
        int eC = 0;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(map[i][j] == '.')
                    continue;

                int cnt = 0;
                // 네 방향 탐색
                for(int k=0; k<4; k++)
                {
                    int newI = i + dr[k];
                    if(newI < 0 || newI >= R)
                    {
                        cnt++;
                        continue;
                    }

                    int newJ = j + dc[k];
                    if(newJ < 0 || newJ >= C)
                    {
                        cnt++;
                        continue;
                    }

                    if(map[newI][newJ] == '.')
                        cnt++;
                }

                if(cnt >= 3)
                    map[i][j] = ',';
                else
                {
                    sR = Math.min(i, sR);
                    eR = Math.max(i, eR);
                    sC = Math.min(j, sC);
                    eC = Math.max(j, eC);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=sR; i<=eR; i++)
        {
            for(int j=sC; j<=eC; j++)
                if(map[i][j] == 'X')
                    sb.append(map[i][j]);
                else
                    sb.append('.');

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
