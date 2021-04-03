import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-13
 * Time: 오후 3:46
 */

public class kakao2021_1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String newId = br.readLine();

        newId = newId.toLowerCase();

        int len = newId.length();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<len; i++)
        {
            char ch = newId.charAt(i);

            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.')
                sb.append(ch);
        }

        newId = sb.toString();
        len = newId.length();
        for(int i=0; i<len-1; i++)
        {
            char cur = newId.charAt(i);
            char next = newId.charAt(i+1);

            if(cur == '.' && next == '.')
            {
                newId = new StringBuffer().append(newId, 0, i+1).append(newId, i+2, len).toString();
                i--;
                len--;
            }
        }

        while(!newId.equals(""))
        {
            if(newId.charAt(0) == '.')
                newId = newId.replaceFirst(".", "");
            else if(newId.charAt(newId.length()-1) == '.')
                newId = new StringBuffer().append(newId, 0, newId.length()-1).toString();
            else
                break;
        }

        if(newId.equals(""))
            newId = "a";

        len = newId.length();
        if(len >= 16)
        {
            newId = new StringBuffer().append(newId, 0, 15).toString();
            len = newId.length();
            if(newId.charAt(len-1) == '.')
                newId = new StringBuffer().append(newId, 0, len-1).toString();
        }

        len = newId.length();
        if(len <= 2)
        {
            sb = new StringBuffer().append(newId);
            while(newId.length() < 3)
                newId = sb.append(newId.charAt(len-1)).toString();
        }

        System.out.println(newId);
    }
}
