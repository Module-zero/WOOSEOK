import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-31
 * Time: 오후 2:02
 */

public class Q5883
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int[] B = new int[1001];
        for(int i=0; i<N; i++)
        {
            B[i] = Integer.parseInt(br.readLine());
            if(set.contains(B[i]))
                continue;
            else
            {
                set.add(B[i]);
                queue.add(B[i]);
            }
        }

        int ans = 1;
        while(!queue.isEmpty())
        {
            int target = queue.poll();
            int cnt = 1;
            int prev = -1;

            for(int i=0; i<N; i++)
            {
                if(B[i] == target)
                    continue;

                if(prev != B[i])
                    cnt = 1;
                else
                {
                    cnt++;
                    ans = Integer.max(ans, cnt);
                }

                prev = B[i];
            }
        }

        System.out.println(ans);
    }
}
