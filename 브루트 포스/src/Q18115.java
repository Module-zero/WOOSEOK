import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-17
 * Time: 오후 3:48
 */

public class Q18115
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[1000001];
        Deque<Integer> dq = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
            ans.add(i);
        }

        for(int i=N; i>=1; i--)
        {
            switch(A[i])
            {
                case 1:
                    dq.addFirst(ans.poll());
                    break;
                case 2:
                    int tmp = dq.poll();
                    dq.addFirst(ans.poll());
                    dq.addFirst(tmp);
                    break;
                case 3:
                    dq.addLast(ans.poll());
                    break;
                default:
                    break;
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!dq.isEmpty())
            sb.append(dq.poll()).append(' ');

        System.out.println(sb.toString());
    }
}
