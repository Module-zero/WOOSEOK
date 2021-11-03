import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-03
 * Time: 오후 4:44
 */

public class Q3107
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = new String[8];
        String str = br.readLine();
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        int id = 0;
        for(int i=0; i<len; i++)
        {
            char ch = str.charAt(i);
            if(ch == ':')
            {
                strs[id] = sb.toString();
                sb = new StringBuffer();
                if(i != 0 && i != len-1)
                    id++;
            }
            else
                sb.append(ch);
        }

        if(!sb.toString().equals(""))
            strs[id] = sb.toString();

        int i = 0;
        sb = new StringBuffer();
        while(i <= id)
        {
            int l = strs[i].length();

            if(l == 0)
            {
                for(int j=0; j<8-id; j++)
                    sb.append("0000:");
            }
            else
            {
                for(int j=0; j<4-l; j++)
                    sb.append(0);

                sb.append(strs[i]).append(':');
            }

            i++;
        }

        len = sb.length();
        System.out.println(sb.substring(0, len-1).toString());
    }
}
