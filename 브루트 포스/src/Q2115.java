import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-17
 * Time: 오후 4:09
 */

public class Q2115
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] ary = new char[1001][1001];
        for(int i=0; i<M; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        int[][] map = new int[1001][1001];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int ans = 0;
        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(ary[i][j] != '.')
                    continue;

                for(int k=0; k<2; k++)
                {
                    int newR = i + dr[k];
                    if(newR < 0 || newR >= M)
                        continue;

                    int newC = j + dc[k];
                    if(newC < 0 || newC >= N)
                        continue;

                    if(ary[newR][newC] != '.')
                        continue;

                    for(int l=0; l<4; l++)
                    {
                        if(k == 0 && l % 2 == 0)
                            continue;
                        if(k == 1 && l % 2 == 1)
                            continue;

                        int newR1 = i + dr[l];
                        if(newR1 < 0 || newR1 >= M)
                            continue;

                        int newC1 = j + dc[l];
                        if(newC1 < 0 || newC1 >= N)
                            continue;

                        int newR2 = newR + dr[l];
                        if(newR2 < 0 || newR2 >= M)
                            continue;

                        int newC2 = newC + dc[l];
                        if(newC2 < 0 || newC2 >= N)
                            continue;

                        if(ary[newR1][newC1] != 'X' || ary[newR2][newC2] != 'X')
                            continue;

                        int wall = 1 << l;
                        // 이미 그림을 걸었으면 continue
                        if((map[i][j] & wall) != 0 || (map[newR][newC] & wall) != 0)
                            continue;

                        map[i][j] |= wall;
                        map[newR][newC] |= wall;
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
