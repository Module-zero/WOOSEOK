import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-16
 * Time: 오후 5:02
 */

public class Qtest1
{
    public static long foo(long p, long n)
    {
        if(n == 0)
            return 1;

        long value = foo(p, n/2);
        value = value * value % 1000000007;

        if(n % 2 == 0)
            return value;
        else
            return value * p % 1000000007;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        System.out.println(K * foo(P, N) % 1000000007);
    }
}
