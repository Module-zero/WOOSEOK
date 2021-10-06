import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 3:28
 */

public class Q2750
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
            sb.append(pq.poll()).append('\n');

        System.out.print(sb.toString());
    }
}
