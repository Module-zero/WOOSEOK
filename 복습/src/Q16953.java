import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-02
 * Time: 오후 2:36
 */

public class Q16953
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(A == B)
        {
            System.out.println(1);
            return;
        }

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 0});
        while(!queue.isEmpty())
        {
            long[] tmp = queue.poll();
            tmp[1] += 1;

            long ta = 2*tmp[0];
            if(ta <= B)
            {
                if(ta == B)
                {
                    System.out.println(tmp[1] + 1);
                    return;
                }

                queue.add(new long[]{ta, tmp[1]});
            }
            long tb = 10*tmp[0] + 1;
            if(tb <= B)
            {
                if(tb == B)
                {
                    System.out.println(tmp[1] + 1);
                    return;
                }

                queue.add(new long[]{tb, tmp[1]});
            }
        }

        System.out.println(-1);
    }
}
