import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 3:31
 */

public class Q14405
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String[] strs = {"pi", "ka", "chu"};
        int[] len = {2, 2, 3};
        int slen = S.length();

        for(int i=0; i<slen; )
        {
            boolean isFound = false;
            for(int j=0; j<3; j++)
            {
                if(slen < i+len[j])
                    continue;

                String ss = S.substring(i, i+len[j]);

                if(ss.equals(strs[j]))
                {
                    isFound = true;
                    i += len[j];
                    break;
                }
            }

            if(isFound)
                continue;
            else
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
