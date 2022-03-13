import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-04
 * Time: 오후 1:36
 */

public class Q18311
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] ary = new long[100001];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Long.parseLong(st.nextToken());

        for(int i=1; i<=N; i++)
        {
            K = K - ary[i];
            if(K < 0)
            {
                System.out.println(i);
                return;
            }
            else if(K == 0)
            {
                if(i == N)
                    System.out.println(i);
                else
                    System.out.println(i+1);
                return;
            }
        }

        for(int i=N; i>=1; i--)
        {
            K = K - ary[i];
            if(K < 0)
            {
                System.out.println(i);
                return;
            }
            else if(K == 0)
            {
                System.out.println(i-1);
                return;
            }
        }
    }
}
