import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 10:50
 */

public class Q9625
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int a = 1;
        int b = 0;
        while(K-- > 0)
        {
            int tmp = b;
            b += a;
            a = tmp;
        }

        System.out.println(a + " " + b);
    }
}
