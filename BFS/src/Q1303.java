import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-16
 * Time: 오후 7:08
 */

public class Q1303
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[101][101];

        for(int i=0; i<M; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        boolean[][] check = new boolean[101][101];
        int ally = 0;
        int enemy = 0;

        for(int r=0; r<M; r++)
        {
            for(int c=0; c<N; c++)
            {
                if(check[r][c])
                    continue;

                int cnt = 1;
                check[r][c] = true;
                queue.add(new int[]{r, c});

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    for(int i=0; i<4; i++)
                    {
                        int newR = tmp[0] + dr[i];
                        if(newR < 0 || newR >= M)
                            continue;

                        int newC = tmp[1] + dc[i];
                        if(newC < 0 || newC >= N)
                            continue;

                        if(check[newR][newC])
                            continue;
                        if(ary[tmp[0]][tmp[1]] != ary[newR][newC])
                            continue;

                        check[newR][newC] = true;
                        queue.add(new int[]{newR, newC});
                        cnt++;
                    }
                }

                if(ary[r][c] == 'W')
                    ally += cnt*cnt;
                else
                    enemy += cnt*cnt;
            }
        }

        System.out.println(ally + " " + enemy);
    }
}
