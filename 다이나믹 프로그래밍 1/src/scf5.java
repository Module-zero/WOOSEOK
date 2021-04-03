import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 2:57
 */

public class scf5
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] ary = new char[1001][21];
        ArrayList<int[]> start = new ArrayList<>();
        for(int i=0; i<M; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
            {
                ary[i][j] = str.charAt(j);
                if(ary[i][j] == 'c')
                    start.add(new int[]{i, j});
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dr = {0, 0, 1};
        int[] dc = {1, -1, 0};
        int size = start.size();
        int ans = Integer.MAX_VALUE;
        for(int a=0; a<size; a++)
        {
            int[] tary = start.get(a);

            // -1로 초기화
            int[][] map = new int[1001][21];
            for(int i=0; i<M; i++)
            {
                for(int j=0; j<N; j++)
                    map[i][j] = -1;
            }

            queue.add(new int[]{tary[0], tary[1]});
            map[tary[0]][tary[1]] = 0;

            while(!queue.isEmpty())
            {
                int[] tmp = queue.poll();

                for(int k=0; k<3; k++)
                {
                    int newR = tmp[0] + dr[k];
                    if(newR > M)
                        continue;

                    int newC = tmp[1] + dc[k];
                    if(newC < 0 || newC >= N)
                        continue;

                    if(map[newR][newC] != -1 || ary[newR][newC] == 'x')
                        continue;

                    if(k != 2)
                        map[newR][newC] = map[tmp[0]][tmp[1]] + 1;
                    else
                        map[newR][newC] = map[tmp[0]][tmp[1]];

                    if(newR == M-1)
                    {
                        ans = Integer.min(ans, map[newR][newC]);
                        continue;
                    }

                    queue.add(new int[]{newR, newC});
                }
            }
        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
