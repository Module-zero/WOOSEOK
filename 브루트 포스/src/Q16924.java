/*
십자가 찾기

https://www.acmicpc.net/problem/16924
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 4:08
 */

public class Q16924
{
    static int N;
    static int M;
    static char[][] ary = new char[101][101];
    static boolean[][] check = new boolean[101][101];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    // r, c : 좌표, n : 크기
    public static boolean cross(int r, int c, int n)
    {
        for(int i=0; i<4; i++)
        {
            int cnt = 0;

            int newRow = r;
            int newCol = c;
            // 각 방향으로 n번 이동해가며 검사
            while(cnt < n)
            {
                newRow += dr[i];
                if(newRow <= 0 || newRow > N)
                    return false;

                newCol += dc[i];
                if(newCol <= 0 || newCol > M)
                    return false;

                // 해당 위치가 *이 아니면 n 크기의 십자가가 될 수 없음
                if(ary[newRow][newCol] != '*')
                    return false;

                cnt++;
            }
        }

        // 십자가로 그릴 수 있는 '*'이라는 것을 기록
        for(int i = r - n; i <= r + n; i++)
            check[i][c] = true;
        for(int i = c - n; i <= c + n; i++)
            check[r][i] = true;

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(ary[i][j] == '*')
                {
                    for(int n=(M-2)/2; n>=1; n--)
                    {
                        // n 크기의 십자가가 가능하면 출력
                        if (cross(i, j, n))
                        {
                            cnt++;
                            sb.append(i).append(' ').append(j).append(' ').append(n).append('\n');
                            break;
                        }
                    }
                }
            }
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                // 그리지 못하는 '*'이 있으면 종료
                if(ary[i][j] == '*' && check[i][j] == false)
                {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if(cnt == 0)
            System.out.println(-1);
        else
        {
            System.out.println(cnt);
            System.out.print(sb.toString());
        }
    }
}
