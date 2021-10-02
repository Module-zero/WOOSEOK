import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 4:41
 */

public class Q12782
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String N = st.nextToken();
            String M = st.nextToken();

            int num0 = 0;
            int num1 = 0;
            int len = N.length();
            for(int i=0; i<len; i++)
            {
                char cn = N.charAt(i);
                char cm = M.charAt(i);

                // N을 기준으로
                if(cn != cm)
                {
                    if(cn == '0')
                        num0++;
                    else
                        num1++;
                }
            }

            if(num0 < num1)
            {
                num0 += num1 - num0;
                sb.append(num0).append('\n');
            }
            else
            {
                num1 += num0 - num1;
                sb.append(num1).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
