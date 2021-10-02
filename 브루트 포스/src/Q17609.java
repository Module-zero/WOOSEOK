import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-07
 * Time: 오후 10:40
 */

public class Q17609
{
    public static int isPalindrome(String str, int a, int b, boolean isRemove)
    {
        if(a >= b)
        {
            if(isRemove)
                return 1;
            else
                return 0;
        }

        if(str.charAt(a) == str.charAt(b))
            return isPalindrome(str, a+1, b-1, isRemove);
        else
        {
            if(isRemove)
                return 2;

            if(str.charAt(a) == str.charAt(b-1) && str.charAt(a+1) == str.charAt(b))
            {
                int r1 = isPalindrome(str, a, b-1, true);
                int r2 = isPalindrome(str, a+1, b, true);

                if(r1 < r2)
                    return r1;
                else
                    return r2;
            }
            else if(str.charAt(a) == str.charAt(b-1))
                return isPalindrome(str, a, b-1, true);
            else if(str.charAt(a+1) == str.charAt(b))
                return isPalindrome(str, a+1, b, true);
            else
                return 2;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<T; i++)
        {
            String str = br.readLine();

            int ret = isPalindrome(str, 0, str.length()-1, false);
            sb.append(ret).append('\n');
        }

        System.out.print(sb.toString());
    }
}
