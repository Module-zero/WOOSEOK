import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 10:55
 */

public class Q9506
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            int n = Integer.parseInt(br.readLine());
            if(n == -1)
                break;

            int ans = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=1; i*i<=n; i++)
            {
                if(n % i == 0)
                {
                    ans += i;
                    pq.add(i);
                    if(n / i != i)
                    {
                        if(n / i != n)
                        {
                            ans += n / i;
                            pq.add(n / i);
                        }
                    }
                }
            }

            sb.append(n);
            if(n == ans)
            {
                sb.append(" = ").append(pq.poll());
                while(!pq.isEmpty())
                    sb.append(" + ").append(pq.poll());
                sb.append('\n');
            }
            else
                sb.append(" is NOT perfect.\n");
        }

        System.out.print(sb.toString());
    }
}
