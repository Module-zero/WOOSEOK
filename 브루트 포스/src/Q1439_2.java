import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-13
 * Time: 오전 12:44
 */

public class Q1439_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int len = S.length();
        int cnt = 1;
        char prev = S.charAt(0);
        for(int i=1; i<len; i++)
        {
            char ch = S.charAt(i);
            if(ch != prev)
            {
                prev = ch;
                cnt++;
            }
        }

        System.out.println(cnt/2);
    }
}
