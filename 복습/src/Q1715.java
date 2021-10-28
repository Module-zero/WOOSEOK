import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-28
 * Time: 오후 1:38
 */

public class Q1715
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        while(pq.size() != 1)
        {
            int n1 = pq.poll();
            int n2 = pq.poll();

            int newn = n1 + n2;
            ans += newn;
            pq.add(newn);
        }

        System.out.println(ans);
    }
}
