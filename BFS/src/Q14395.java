import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 1:41
 */

public class Q14395
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] dc = {'*', '+', '-', '/'};
        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{s, 0});

        while(!queue.isEmpty())
        {
            long[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                char ch = dc[i];

                switch(ch)
                {
                    case '*':
                        break;
                    case '+':
                        break;
                    case '-':
                        break;
                    case '/':
                        break;
                }
            }
        }
    }
}
