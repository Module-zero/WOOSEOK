import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 8:58
 */

public class Q2744
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuffer sb = new StringBuffer();

        int len = str.length();
        for(int i=0; i<len; i++)
        {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z')
                sb.append((char)(ch - 32));
            else
                sb.append((char)(ch + 32));
        }

        System.out.println(sb.toString());
    }
}
