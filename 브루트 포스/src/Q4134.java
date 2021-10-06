import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 7:11
 */

public class Q4134
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(tc-- > 0)
        {
            long n = Long.parseLong(br.readLine());

            long tmp = n;
            while(true)
            {
                if(tmp == 0 || tmp == 1)
                {
                    tmp++;
                    continue;
                }

                boolean notPrime = false;

                for(long k=2; k*k<=tmp; k++)
                {
                    if(tmp % k == 0)
                    {
                        notPrime = true;
                        break;
                    }
                }

                if(!notPrime)
                    break;

                tmp++;
            }

            sb.append(tmp).append('\n');
        }

        System.out.print(sb.toString());
    }
}
