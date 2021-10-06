import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 4:05
 */

public class Q12871
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        int slen = s.length();
        int tlen = t.length();

        int alen = 0;
        int blen = 0;
        String astr = null;
        String bstr = null;
        if(slen < tlen)
        {
            alen = slen;
            blen = tlen;
            astr = s;
            bstr = t;
        }
        else
        {
            alen = tlen;
            blen = slen;
            astr = t;
            bstr = s;
        }

        blen += blen;
        bstr += bstr;

        for(int i=0, j=0; j<blen; i = (i + 1) % alen, j++)
        {
            if(astr.charAt(i) != bstr.charAt(j))
            {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
