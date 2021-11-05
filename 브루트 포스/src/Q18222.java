import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-05
 * Time: 오후 2:32
 */

public class Q18222
{
    public static int foo(long K)
    {
        if(K == 1)
            return 0;

        long i=1;
        while(i+i<K)
            i+=i;

        return 1 - foo(K-i);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());
        System.out.println(foo(K));
    }
}
