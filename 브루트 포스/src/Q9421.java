import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 5:32
 */

public class Q9421
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1000001];
        for(int i=2; i<=n; i++)
        {
            isPrime[i] = true;
            for(int j=2; j*j<=i; j++)
            {
                if(i%j == 0)
                {
                    isPrime[i] = false;
                    break;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=n; i++)
        {
            if(!isPrime[i])
                continue;

            int tmp = i;
            int value = 0;
            while(tmp > 0)
            {
                int num = tmp % 10;
                value += num*num;
                tmp /= 10;
            }

            TreeSet<Integer> set = new TreeSet<>();
            while(true)
            {
                if(!set.add(value))
                    break;

                int tv = 0;
                while(value > 0)
                {
                    int num = value % 10;
                    tv += num*num;
                    value /= 10;
                }

                value = tv;
                if(value == 1)
                {
                    sb.append(i).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}
