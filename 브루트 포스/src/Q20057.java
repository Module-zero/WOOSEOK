import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 11:29
 */

public class Q20057
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[500][500];

        int[][][] rotate = {{{-2, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -2}, {1, -1}, {1, 0}, {1, 1}, {2, 0}, {0, -1}},
                            {{0, -2}, {1, -1}, {0, -1}, {-1, -1}, {2, 0}, {1, 1}, {0, 1}, {-1, 1}, {0, 2}, {1, 0}},
                            {{2, 0}, {1, 1}, {1, 0}, {1, -1}, {0, 2}, {-1, 1}, {-1, 0}, {-1, -1}, {-2, 0}, {0, 1}},
                            {{0, 2}, {-1, 1}, {0, 1}, {1, 1}, {-2, 0}, {-1, -1}, {0, -1}, {1, -1}, {0, -2}, {-1, 0}}};
        int[] num = {2, 10, 7, 1, 5, 10, 7, 1, 2};

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int dist = 0;
        int dir = 0;
        int curR = N/2;
        int curC = N/2;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};

        int ans = 0;
        while(dist < N)
        {
            if(dir % 2 == 0)
                dist++;

            for(int i=0; i<dist; i++)
            {
                int total = 0;

                curR += dr[dir % 4];
                curC += dc[dir % 4];

                for(int j=0; j<9; j++)
                {
                    int sand = ary[curR][curC] * num[j] / 100;
                    total += sand;

                    // 격자 밖으로 나간 모래
                    int newR = curR + rotate[dir%4][j][0];
                    if(newR < 0 || newR >= N)
                    {
                        ans += sand;
                        continue;
                    }
                    int newC = curC + rotate[dir%4][j][1];
                    if(newC < 0 || newC >= N)
                    {
                        ans += sand;
                        continue;
                    }

                    ary[newR][newC] += sand;
                }

                int alpha = ary[curR][curC] - total;
                ary[curR][curC] = 0;
                int alphaR = curR + rotate[dir%4][9][0];
                if(alphaR < 0 || alphaR >= N)
                {
                    ans += alpha;
                    break;
                }
                int alphaC = curC + rotate[dir%4][9][1];
                if(alphaC < 0 || alphaC >= N)
                {
                    ans += alpha;
                    break;
                }

                ary[alphaR][alphaC] += alpha;
            }

            if(curR == 0 && curC == 0)
                break;

            dir++;
        }

        System.out.println(ans);
    }
}
