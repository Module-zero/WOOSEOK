import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-17
 * Time: 오전 12:26
 */

public class Q5972
{

    static class PQ implements Comparable<PQ>
    {
        int d;
        int i;

        public PQ(int d, int i)
        {
            this.d = d;
            this.i = i;
        }

        public int compareTo(PQ o)
        {
            return d - o.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[50001];
        int[] B = new int[50001];
        int[] C = new int[50001];
        ArrayList<int[]>[] list = new ArrayList[50001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());

            list[A[i]].add(new int[]{B[i], C[i]});
            list[B[i]].add(new int[]{A[i], C[i]});
        }

        boolean[] check = new boolean[50001];
        PriorityQueue<PQ> pq = new PriorityQueue<>();
        pq.add(new PQ(0, 1));
        while(!pq.isEmpty())
        {
            PQ tmp = pq.poll();
            if(tmp.i == N)
            {
                System.out.println(tmp.d);
                return;
            }

            check[tmp.i] = true;
            for(int[] next : list[tmp.i])
            {
                if(check[next[0]])
                    continue;

                pq.add(new PQ(tmp.d + next[1], next[0]));
            }
        }
    }
}
