import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 3:39
 */

public class Q11719
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            sb.append(str).append('\n');
        }

        System.out.print(sb.toString());
    }
}
