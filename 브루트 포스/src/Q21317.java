import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-12
 * Time: 오후 8:36
 */

public class Q21317
{
    static int N;
    static int[] big = new int[21];
    static int[] small = new int[21];
    static int K;
    static int min = Integer.MAX_VALUE;

    public static void foo(int index, int sum, boolean veryBig)
    {
        if(index == N)
        {
            min = Integer.min(min, sum);
            return;
        }

        foo(index+1, sum+small[index], veryBig);
        if(index+2 <= N)
            foo(index+2, sum+big[index], veryBig);
        if(index+3 <= N && !veryBig)
            foo(index+3, sum+K, true);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        foo(1, 0, false);

        System.out.println(min);
    }
}
