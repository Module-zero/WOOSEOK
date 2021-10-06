import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-14
 * Time: 오후 11:30
 */

public class Q15904
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String ans = "UCPC";
        int k = 0;

        int len = str.length();
        for(int i=0; i<len; i++)
        {
            if(str.charAt(i) == ans.charAt(k))
            {
                k++;
                if(k == 4)
                {
                    System.out.println("I love UCPC");
                    return;
                }
            }
        }

        System.out.println("I hate UCPC");
    }
}
