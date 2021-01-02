/*
주사위 굴리기

https://www.acmicpc.net/problem/14499
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-27
 * Time: 오후 5:06
 */

public class Q14499
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[21][21];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        int[] dice = new int[6];
        int up = 0;
        int right = 2;
        int front = 4;
        for(int i=0; i<K; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            boolean isMove = false;

            switch(num)
            {
                // 동쪽
                case 1:
                    if(y + 1 < M)
                    {
                        y++;
                        isMove = true;

                        int tmp = up;
                        up = 5 - right; // 왼쪽면이 위로
                        right = tmp; // 윗면이 오른쪽으로
                    }
                    break;
                // 서쪽
                case 2:
                    if(y - 1 >= 0)
                    {
                        y--;
                        isMove = true;

                        int tmp = up;
                        up = right; // 오른쪽면이 위로
                        right = 5 - tmp; // 아랫면이 오른쪽으로
                    }
                    break;
                // 북쪽
                case 3:
                    if(x - 1 >= 0)
                    {
                        x--;
                        isMove = true;

                        int tmp = up;
                        up = front; // 앞면이 위로
                        front = 5 - tmp; // 밑면이 앞으로
                    }
                    break;
                // 남쪽
                case 4:
                    if(x + 1 < N)
                    {
                        x++;
                        isMove = true;

                        int tmp = up;
                        up = 5 - front; // 뒷면이 위로
                        front = tmp; // 윗면이 앞으로
                    }
                    break;
            }

            if(isMove)
            {
                if(ary[x][y] == 0)
                    ary[x][y] = dice[5-up];
                else
                {
                    dice[5-up] = ary[x][y];
                    ary[x][y] = 0;
                }

                sb.append(dice[up]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
