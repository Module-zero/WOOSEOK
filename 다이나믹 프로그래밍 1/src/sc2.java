import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-19
 * Time: 오후 3:41
 */

public class sc2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long ans1 = N / 5;
            long ans2 = (N + M) / 12;

            sb.append(Long.min(ans1, ans2));
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
