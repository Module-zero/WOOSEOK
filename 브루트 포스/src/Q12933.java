import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-22
 * Time: 오후 1:54
 */

public class Q12933
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ary = br.readLine().toCharArray();
        char[] duck = {'q', 'u', 'a', 'c', 'k'};

        ArrayList<StringBuilder> list = new ArrayList<>();
        for(char ch : ary)
        {
            boolean ok = false;

            for(StringBuilder sb : list)
            {
                int len = sb.length() % 5;
                if(ch == duck[len])
                {
                    sb.append(ch);
                    ok = true;
                    break;
                }
            }

            if(!ok)
            {
                if(ch == duck[0])
                    list.add(new StringBuilder().append(ch));
                else
                {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for(StringBuilder sb : list)
        {
            if(sb.length() % 5 != 0)
            {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(list.size());
    }
}
