import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-07-15
 * Time: 오후 4:24
 */

public class Q3568
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ", ;");
        String common = st.nextToken();

        Queue<String> queue = new LinkedList<>();
        while(st.hasMoreTokens())
        {
            StringBuffer name = new StringBuffer();
            StringBuffer op = new StringBuffer();

            String str = st.nextToken();
            int len = str.length();
            for(int i=0; i<len; i++)
            {
                char ch = str.charAt(i);
                if(ch == '[')
                {
                    op.append("][");
                    i++;
                }
                else if(ch >= 'A' && ch <= 'z')
                    name.append(ch);
                else
                    op.append(ch);
            }

            queue.add(new StringBuffer(common).append(op.reverse()).append(' ').append(name).append(";").toString());
        }

        while(!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
