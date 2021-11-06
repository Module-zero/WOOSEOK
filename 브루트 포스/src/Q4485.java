import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 1:40
 */

public class Q4485
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int[][] map = new int[125][125];
        for(int cnt=1; ; cnt++)
        {
            int N = Integer.parseInt(br.readLine());
            if(N == 0)
                break;

            for(int i=0; i<N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int[][] dist = new int[125][125];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                    dist[i][j] = 20000;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(1000, new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[2] - o2[2];
                }
            });

            pq.add(new int[]{0, 0, map[0][0]});
            dist[0][0] = map[0][0];
            while(!pq.isEmpty())
            {
                int[] tmp = pq.poll();
                if(tmp[2] > dist[tmp[0]][tmp[1]])
                    continue;

                for(int i=0; i<4; i++)
                {
                    int newR = tmp[0] + dr[i];
                    if(newR < 0 || newR >= N)
                        continue;

                    int newC = tmp[1] + dc[i];
                    if(newC < 0 || newC >= N)
                        continue;

                    int newd = tmp[2] + map[newR][newC];
                    if(newd < dist[newR][newC])
                    {
                        dist[newR][newC] = newd;
                        pq.add(new int[]{newR, newC, newd});
                    }
                }
            }

            sb.append("Problem ").append(cnt).append(": ").append(dist[N-1][N-1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
