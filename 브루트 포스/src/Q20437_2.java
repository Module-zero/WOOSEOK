import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-13
 * Time: 오후 9:49
 */

public class Q20437_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] lists = new ArrayList[26];
            for(int i=0; i<26; i++)
                lists[i] = new ArrayList<>();

            int len = W.length();
            for(int i=0; i<len; i++)
            {
                int id = W.charAt(i) - 'a';
                lists[id].add(i);
            }

            int s = Integer.MAX_VALUE;
            int l = 0;
            for(int i=0; i<26; i++)
            {
                ArrayList<Integer> list = lists[i];
                int size = list.size();
                for(int j=K-1; j<size; j++)
                {
                    s = Integer.min(s, list.get(j) - list.get(j - K + 1) + 1);
                    l = Integer.max(l, list.get(j) - list.get(j - K + 1) + 1);
                }
            }

            if(s == Integer.MAX_VALUE || l == 0)
                sb.append("-1\n");
            else
                sb.append(s).append(' ').append(l).append('\n');
        }

        System.out.print(sb.toString());
    }
}
