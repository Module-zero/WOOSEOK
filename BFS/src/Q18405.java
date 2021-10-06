import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-16
 * Time: 오후 6:38
 */

public class Q18405
{
    static class Temp implements Comparable<Temp>
    {
        int r;
        int c;
        int level;
        int sec;

        public Temp(int r, int c, int level, int sec)
        {
            this.r = r;
            this.c = c;
            this.level = level;
            this.sec = sec;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(this.sec > o.sec)
                return 1;
            else if(this.sec < o.sec)
                return -1;
            else
            {
                if(this.level > o.level)
                    return 1;
                else if(this.level < o.level)
                    return -1;
                else
                    return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        int[][] ary = new int[201][201];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] != 0)
                    pq.add(new Temp(i, j, ary[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int t=0; t<S; t++)
        {
            while(!pq.isEmpty() && pq.peek().sec == t)
            {
                Temp tmp = pq.poll();

                for(int i=0; i<4; i++)
                {
                    int newR = tmp.r + dr[i];
                    if(newR < 0 || newR >= N)
                        continue;

                    int newC = tmp.c + dc[i];
                    if(newC < 0 || newC >= N)
                        continue;

                    if(ary[newR][newC] != 0)
                        continue;

                    ary[newR][newC] = tmp.level;
                    pq.add(new Temp(newR, newC, tmp.level, tmp.sec+1));
                }
            }
        }

        System.out.println(ary[X-1][Y-1]);
    }
}
