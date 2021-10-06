import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 5:40
 */

public class Q1059
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0; i<L; i++)
            pq.add(Integer.parseInt(st.nextToken()));
        int n = Integer.parseInt(br.readLine());

        int prev = 0;
        int next = 0;
        while(!pq.isEmpty())
        {
            next = pq.poll();
            if(n == next)
            {
                System.out.println(0);
                return;
            }
            else if(n < next)
                break;
            else
                prev = next;
        }

        int ans = 0;
        prev++; // 겹치면 안되므로
        next--;
        // 왼쪽 구간
        ans += ((n-1) - prev + 1) * (next - n + 1);

        // 오른쪽 구간
        ans += next - (n+1) + 1;

        System.out.println(ans);
    }
}
