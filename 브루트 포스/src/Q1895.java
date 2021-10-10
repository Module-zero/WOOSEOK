import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오전 1:14
 */

public class Q1895
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] ary = new int[41][41];
        for(int i=0; i<R; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<R-2; i++)
        {
            for(int j=0; j<C-2; j++)
            {
                PriorityQueue<Integer> pq = new PriorityQueue<>();

                for(int k=0; k<3; k++)
                {
                    for(int l=0; l<3; l++)
                        pq.add(ary[i+k][j+l]);
                }

                pq.poll();
                pq.poll();
                pq.poll();
                pq.poll();
                int num = pq.poll();
                if(num >= T)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
