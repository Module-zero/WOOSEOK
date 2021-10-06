import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오후 4:34
 */

public class Q2800
{
    static boolean[] check = new boolean[201];
    static char[] ary;
    static ArrayList<Integer> openIndex = new ArrayList<>();
    static ArrayList<Integer> closeIndex = new ArrayList<>();
    static int size;
    static int len;
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void foo(int id, int cnt)
    {
        if(id == size)
        {
            if(cnt == 0)
                return;

            StringBuffer sb = new StringBuffer();
            for(int i=0; i<len; i++)
            {
                if(check[i])
                    continue;

                sb.append(ary[i]);
            }

            pq.add(sb.toString());
            return;
        }

        int ti = openIndex.get(id);
        int oi = closeIndex.get(id);
        check[ti] = true;
        check[oi] = true;
        foo(id+1, cnt+1);
        check[ti] = false;
        check[oi] = false;
        foo(id+1, cnt);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        ary = str.toCharArray();
        len = str.length();

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++)
        {
            if(ary[i] == '(')
                stack.push(i);
            else if(ary[i] == ')')
            {
                int id = stack.pop();
                openIndex.add(id);
                closeIndex.add(i);
            }
        }

        size = openIndex.size();

        foo(0, 0);

        StringBuffer sb = new StringBuffer();
        String prev = "";
        while(!pq.isEmpty())
        {
            String cur = pq.poll();
            if(cur.equals(prev))
                continue;

            sb.append(cur).append('\n');
            prev = cur;
        }

        System.out.print(sb.toString());
    }
}
