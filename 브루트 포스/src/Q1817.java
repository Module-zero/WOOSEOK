import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 3:48
 */

public class Q1817
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        if(N > 0)
        {
            ans = 1;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
            {
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
            }

            int rem = M;
            while(!stack.isEmpty())
            {
                int tmp = stack.pop();
                if(rem < tmp)
                {
                    rem = M - tmp;
                    ans++;
                }
                else
                    rem -= tmp;
            }
        }

        System.out.println(ans);
    }
}
