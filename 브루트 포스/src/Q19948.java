import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-14
 * Time: 오후 5:45
 */

public class Q19948
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int space = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<26; i++)
            cnt[i] = Integer.parseInt(st.nextToken());

        int len = str.length();
        char prev = 0;
        StringBuffer sb = new StringBuffer();
        sb.append(str.charAt(0));

        for(int i=0; i<len; i++)
        {
            char ch = str.charAt(i);

            if(ch == prev)
                continue;

            if(prev == ' ')
                sb.append(ch);

            if(ch == ' ')
            {
                space--;
                if(space < 0)
                {
                    System.out.println(-1);
                    return;
                }
                prev = ch;
                continue;
            }

            if(ch >= 'a' && ch <= 'z')
                ch -= 'a' - 'A';

            int id = ch - 'A';
            cnt[id]--;
            if(cnt[id] < 0)
            {
                System.out.println(-1);
                return;
            }

            prev = str.charAt(i);
        }

        str = sb.toString();
        len = str.length();
        prev = 0;
        for(int i=0; i<len; i++)
        {
            char ch = str.charAt(i);
            if(prev == ch)
                continue;

            if(ch >= 'a' && ch <= 'z')
                ch -= 'a' - 'A';

            int id = ch - 'A';
            cnt[id]--;
            if(cnt[id] < 0)
            {
                System.out.println(-1);
                return;
            }

            prev = str.charAt(i);
        }

        System.out.println(str.toUpperCase());
    }
}
