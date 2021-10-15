import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-15
 * Time: 오후 10:00
 */

public class Q18430
{
    static int[][][] boom = {{{0, -1}, {1, 0}}, {{-1, 0}, {0, -1}}, {{-1, 0}, {0, 1}}, {{0, 1}, {1, 0}}};
    static int[][] ary = new int[5][5];
    static boolean[][] check = new boolean[5][5];
    static int N;
    static int M;
    static int ans = 0;

    public static void foo(int r, int c, int sum)
    {
        if(r == N && c == 0)
        {
            ans = Integer.max(ans, sum);
            return;
        }

        if(check[r][c])
        {
            if(c == M-1)
                foo(r+1, 0, sum);
            else
                foo(r, c+1, sum);
        }
        else
        {
            for(int i=0; i<4; i++)
            {
                int[][] tmp = boom[i];

                boolean ok = true;
                int tsum = 2*ary[r][c];
                int[] nextR = new int[2];
                int[] nextC = new int[2];

                for(int j=0; j<2; j++)
                {
                    int newR = r + tmp[j][0];
                    if(newR < 0 || newR >= N)
                    {
                        ok = false;
                        break;
                    }

                    int newC = c + tmp[j][1];
                    if(newC < 0 || newC >= M)
                    {
                        ok = false;
                        break;
                    }

                    if(check[newR][newC])
                    {
                        ok = false;
                        break;
                    }

                    nextR[j] = newR;
                    nextC[j] = newC;
                    tsum += ary[newR][newC];
                }

                if(!ok)
                    continue;

                check[r][c] = true;
                check[nextR[0]][nextC[0]] = true;
                check[nextR[1]][nextC[1]] = true;

                if(c == M-1)
                    foo(r+1, 0, sum + tsum);
                else
                    foo(r, c+1, sum + tsum);

                check[r][c] = false;
                check[nextR[0]][nextC[0]] = false;
                check[nextR[1]][nextC[1]] = false;
            }

            if(c == M-1)
                foo(r+1, 0, sum);
            else
                foo(r, c+1, sum);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0, 0);
        System.out.println(ans);
    }
}
