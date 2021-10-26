import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-25
 * Time: 오후 1:03
 */

public class Q20444
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long start = 0;
        long end = n/2;
        while(start <= end)
        {
            long mid = (start + end) / 2;

            long cnt = (mid+1) * (n - mid + 1);
            if(cnt == k)
            {
                System.out.println("YES");
                return;
            }
            else if(cnt < k)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println("NO");
    }
}
