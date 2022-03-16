import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-15
 * Time: 오후 9:24
 */

public class Q1789_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        for(long i=1; ; i++)
        {
            if(S == sum + i)
            {
                System.out.println(i);
                return;
            }
            else if(S < sum + i)
            {
                System.out.println(i - 1);
                return;
            }

            sum += i;
        }
    }
}
