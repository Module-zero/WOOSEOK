import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-09
 * Time: 오후 11:41
 */

public class Q9536
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] strs = new String[101];
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i = 0;
            while(true)
            {
                String str = br.readLine();
                if(str.equals("what does the fox say?"))
                    break;

                StringTokenizer sst = new StringTokenizer(str);
                sst.nextToken();
                sst.nextToken();
                strs[i] = sst.nextToken();
                i++;
            }

            while(st.hasMoreTokens())
            {
                String s = st.nextToken();
                int j = 0;
                for(; j<i; j++)
                {
                    if(s.equals(strs[j]))
                        break;
                }
                if(j != i)
                    continue;

                sb.append(s).append(' ');
            }

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
