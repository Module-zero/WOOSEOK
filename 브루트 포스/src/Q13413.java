import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오후 3:35
 */

public class Q13413
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String ans = br.readLine();
            int len = str.length();
            int wcnt = 0;
            int bcnt = 0;
            for(int i=0; i<len; i++)
            {
                if(str.charAt(i) != ans.charAt(i))
                {
                    if(ans.charAt(i) == 'W')
                        wcnt++;
                    else
                        bcnt++;
                }
            }

            sb.append(Integer.max(wcnt, bcnt)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
