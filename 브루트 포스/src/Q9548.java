import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오전 12:38
 */

public class Q9548
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer ans = new StringBuffer();
        while(T-- > 0)
        {
            String str = br.readLine();

            StringBuffer sb = new StringBuffer(str);
            while(true)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String com = st.nextToken();
                if(com.equals("END"))
                    break;

                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());

                int len = sb.toString().length();
                if(com.equals("I"))
                {
                    if(b == len)
                        sb.append(a);
                    else
                        sb.insert(b, a);
                }
                else
                    ans.append((sb.substring(Integer.parseInt(a), b+1).toString())).append('\n');
            }
        }

        System.out.print(ans.toString());
    }
}
