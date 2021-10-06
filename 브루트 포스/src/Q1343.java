import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-15
 * Time: 오후 5:24
 */

public class Q1343
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<=len; i++)
        {
            if(i == len || str.charAt(i) == '.')
            {
                if(cnt % 2 == 1)
                {
                    System.out.println(-1);
                    return;
                }

                int r = cnt / 4;
                while(r-- > 0)
                    sb.append("AAAA");

                cnt %= 4;
                r = cnt / 2;
                while(r-- > 0)
                    sb.append("BB");

                if(i != len)
                    sb.append('.');

                cnt = 0;
            }
            else
                cnt++;
        }

        System.out.println(sb.toString());
    }
}
