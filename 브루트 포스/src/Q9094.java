import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 4:34
 */

public class Q9094
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = 0;
            for(int a=1; a<n-1; a++)
            {
                for(int b=a+1; b<n; b++)
                {
                    int sum = a*a + b*b + m;
                    if(sum % (a*b) == 0)
                        ans++;
                }

            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
