import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-28
 * Time: 오후 1:14
 */

public class Q18405
{
    static class Temp implements Comparable<Temp>
    {
        int x;
        int y;
        int v;

        public Temp(int x, int y, int v)
        {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Temp o)
        {
            return v - o.v;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[201][201];

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] != 0)
                    pq.add(new Temp(i, j, ary[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while(S-- > 0)
        {
            PriorityQueue<Temp> cur = pq;
            pq = new PriorityQueue<>();

            while(!cur.isEmpty())
            {
                Temp tmp = cur.poll();

                for(int i=0; i<4; i++)
                {
                    int newR = tmp.x + dr[i];
                    if(newR < 0 || newR >= N)
                        continue;

                    int newC = tmp.y + dc[i];
                    if(newC < 0 || newC >= N)
                        continue;

                    if(ary[newR][newC] != 0)
                        continue;

                    if(newR == X-1 && newC == Y-1)
                    {
                        System.out.println(tmp.v);
                        return;
                    }

                    ary[newR][newC] = tmp.v;
                    pq.add(new Temp(newR, newC, tmp.v));
                }
            }
        }

        System.out.println(ary[X-1][Y-1]);
    }
}
