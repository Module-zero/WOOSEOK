import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:38
 */

public class test5
{
    public static long foo(long a, long b)
    {
        if(b == 0)
            return 1;

        long value = foo(a, b/2);
        value = value * value % 1000000007;

        if(b % 2 == 0)
            return value;
        else
            return value * a % 1000000007;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        System.out.println(K*foo(P, 10*N) % 1000000007);
    }
}
