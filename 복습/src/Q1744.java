import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-26
 * Time: 오후 9:58
 */

public class Q1744
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        while(N-- > 0)
        {
            int num = Integer.parseInt(br.readLine());
            if(num <= 0)
                neg.add(num);
            else
                pos.add(num);
        }

        int ans = 0;
        int prev = 10000;
        while(!pos.isEmpty())
        {
            int tmp = pos.poll();
            if(tmp == 1)
            {
                ans += tmp;
                continue;
            }

            if(prev == 10000)
                prev = tmp;
            else
            {
                ans += prev * tmp;

                prev = 10000;
            }
        }
        if(prev != 10000)
            ans += prev;

        prev = 10000;
        while(!neg.isEmpty())
        {
            int tmp = neg.poll();

            if(prev == 10000)
                prev = tmp;
            else
            {
                ans += prev * tmp;

                prev = 10000;
            }
        }
        if(prev != 10000)
            ans += prev;

        System.out.println(ans);
    }
}
